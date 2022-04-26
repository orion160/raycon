package edu.raycon.renderer;

import edu.raycon.kernel.kernel2d.Kernel2D;
import edu.raycon.kernel.kernel2d.Kernel2DExecutor;
import edu.raycon.kernel.kernel2d.TaskData2D;
import edu.raycon.kernel.kernel2d.strategy.Kernel2DRowStrategy;
import edu.raycon.renderer.kernel.RayTracingInput;
import edu.raycon.renderer.kernel.RayTracingKernel;
import edu.raycon.renderer.presentation.PixelPresent;
import edu.raycon.renderer.raytracing.HittableList;
import edu.raycon.renderer.raytracing.Sphere;
import edu.raycon.util.Vec3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RayTracingRenderer implements IRenderEngine {

  private final Framebuffer framebuffer;

  private final Viewport viewport;

  private final Camera camera;

  private final RendererCommunication communication = new RendererCommunication();

  private final ExecutorService executorService = Executors.newWorkStealingPool();

  public RayTracingRenderer(RendererConfiguration config) {
    this.viewport = config.viewport();
    this.camera = new Camera(viewport);
    framebuffer = new Framebuffer<Vec3>(config.height(), config.width(), Vec3.class);
  }

  @Override
  public void render() {

    var world = new HittableList();
    world.add(new Sphere(new Vec3(0, 0, -1), 0.5));
    world.add(new Sphere(new Vec3(0, -100.5, -1), 100));

    var input = new RayTracingInput(camera, framebuffer, world, 100);
    var taskData =
        new TaskData2D<RayTracingInput, PixelPresent>(
            new RayTracingKernel(), input, output -> communication.triggerEvent(output));

    var kernel = new Kernel2D<>(taskData, 0, framebuffer.getHeight(), 0, framebuffer.getWidth());

    var strategy = new Kernel2DRowStrategy();
    var executor = new Kernel2DExecutor(executorService, strategy);

    executor.execute(kernel);
    executor.shutdown();
  }

  public RendererCommunication getCommunication() {
    return communication;
  }
}

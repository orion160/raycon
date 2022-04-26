package edu.raycon.renderer.kernel;

import edu.raycon.kernel.OnCompleteInvocationCallback;
import edu.raycon.kernel.kernel2d.Runnable2D;
import edu.raycon.renderer.presentation.PixelPresent;
import edu.raycon.renderer.raytracing.HitRecord;
import edu.raycon.renderer.raytracing.Hittable;
import edu.raycon.util.RGBAColor;
import edu.raycon.util.Ray;
import edu.raycon.util.Vec3;

public class RayTracingKernel implements Runnable2D<RayTracingInput, PixelPresent> {

  public static RGBAColor rayColor(Ray r, Hittable world) {

    var rec = new HitRecord();

    if (world.hit(r, 0, Double.POSITIVE_INFINITY, rec)) {
      var c = Vec3.times(Vec3.plus(rec.normal, new Vec3(1, 1, 1)), 0.5);
      return new RGBAColor(c.x(), c.y(), c.z(), 1.0);
    }

    var unitDirection = Vec3.normalize(r.getDirection());
    var t = 0.5 * (unitDirection.y() + 1.0);
    var cBegin = new Vec3(1.0, 1.0, 1.0);
    var cEnd = new Vec3(0.5, 0.7, 1.0);
    var c = Vec3.plus(Vec3.times(cBegin, 1.0 - t), Vec3.times(cEnd, t));

    return new RGBAColor(c.x(), c.y(), c.z(), 1.0);
  }

  @Override
  public void run(
      int i, int j, RayTracingInput input, OnCompleteInvocationCallback<PixelPresent> callback) {

    var pixelColor = new RGBAColor(0.0, 0.0, 0.0, 0.0);
    for (int s = 0; s < input.samplesPerPixel(); s++) {
      var framebuffer = input.framebuffer();
      var u = (double) (j + Math.random()) / (framebuffer.getWidth() - 1);
      var v = (double) (i + Math.random()) / (framebuffer.getHeight() - 1);

      var camera = input.camera();
      var r = camera.get_ray(u, v);

      pixelColor.plus(rayColor(r, input.world()));
    }

    var scale = 1.0 / input.samplesPerPixel();

    pixelColor.r *= scale;
    pixelColor.g *= scale;
    pixelColor.b *= scale;
    pixelColor.a *= scale;

    pixelColor.clamp();

    var info = new PixelPresent(j, i, pixelColor.r, pixelColor.g, pixelColor.b, pixelColor.a);
    callback.onComplete(info);
  }
}

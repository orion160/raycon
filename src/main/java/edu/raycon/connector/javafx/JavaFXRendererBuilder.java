package edu.raycon.connector.javafx;

import edu.raycon.connector.IRendererBuilder;
import edu.raycon.renderer.RayTracingRenderer;
import edu.raycon.renderer.RendererConfiguration;
import javafx.scene.canvas.Canvas;

public class JavaFXRendererBuilder implements IRendererBuilder<RendererComponent> {
  @Override
  public RendererComponent build(RendererConfiguration config) {
    var viewport = config.viewport();
    var canvas = new Canvas(config.width(), config.height());

    var renderer = new RayTracingRenderer(config);

    var writer = canvas.getGraphicsContext2D().getPixelWriter();
    var callback = new OnPresentJavaFXCallback(writer);
    var c = renderer.getCommunication();
    c.addSubscriber(callback);

    var component = new RendererComponent(canvas, renderer);
    return component;
  }
}

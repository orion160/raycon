package edu.raycon.connector.javafx;

import edu.raycon.renderer.IRenderEngine;
import javafx.scene.canvas.Canvas;

public class RendererComponent {
  private final Canvas canvas;

  private final IRenderEngine renderer;

  public RendererComponent(Canvas canvas, IRenderEngine renderer) {
    this.canvas = canvas;
    this.renderer = renderer;
  }

  public Canvas getCanvas() {
    return canvas;
  }

  public void render() {
    renderer.render();
  }
}

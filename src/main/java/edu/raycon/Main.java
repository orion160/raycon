package edu.raycon;

import edu.raycon.connector.javafx.JavaFXRendererBuilder;
import edu.raycon.renderer.RendererConfiguration;
import edu.raycon.renderer.Viewport;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    var width = 1280;
    var height = 720;
    var viewport = new Viewport(2, 16.0 / 9, 1.0);
    var config = new RendererConfiguration(width, height, viewport);

    var b = new JavaFXRendererBuilder();
    var rendererComponent = b.build(config);
    var canvas = rendererComponent.getCanvas();

    var root = new Pane(canvas);
    var scene = new Scene(root, canvas.getWidth(), canvas.getHeight());

    stage.setTitle("Hello Ray Tracing!");
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();

    System.out.println("Threads: " + Thread.activeCount());

    rendererComponent.render();
  }
}

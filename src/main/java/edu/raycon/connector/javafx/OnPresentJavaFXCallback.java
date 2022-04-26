package edu.raycon.connector.javafx;

import edu.raycon.renderer.presentation.OnPresentPixelCallback;
import edu.raycon.renderer.presentation.PixelPresent;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class OnPresentJavaFXCallback implements OnPresentPixelCallback {
  private final PixelWriter writer;

  public OnPresentJavaFXCallback(PixelWriter writer) {
    this.writer = writer;
  }

  @Override
  public synchronized void onPresent(PixelPresent info) {
    writer.setColor(info.x(), info.y(), new Color(info.r(), info.g(), info.b(), info.a()));
  }
}

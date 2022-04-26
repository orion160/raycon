package edu.raycon.renderer;

import edu.raycon.renderer.presentation.OnPresentPixelCallback;
import edu.raycon.renderer.presentation.PixelPresent;

import java.util.ArrayList;
import java.util.List;

public class RendererCommunication {
  private final List<OnPresentPixelCallback> subscribers = new ArrayList<>();

  public synchronized void triggerEvent(PixelPresent info) {
    for (var sub : subscribers) {
      sub.onPresent(info);
    }
  }

  public void addSubscriber(OnPresentPixelCallback s) {
    subscribers.add(s);
  }
}

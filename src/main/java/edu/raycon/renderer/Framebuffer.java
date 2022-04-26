package edu.raycon.renderer;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Framebuffer<T> {
  private final List<List<T>> frameBuffer;

  private final int width;

  private final int height;

  public Framebuffer(int n, int m, Class<T> type) {
    this.height = n;
    this.width = m;
    frameBuffer = new ArrayList<>(n);
    for (int i = 0; i < height; i++) {
      var columns = new ArrayList<T>(width);
      for (int j = 0; j < width; j++) {
        var instance = createType(type);
        columns.add(instance);
      }
      frameBuffer.add(columns);
    }
  }

  private T createType(Class<T> type) {
    T instance = null;
    try {
      instance = type.getDeclaredConstructor().newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

    return instance;
  }

  public List<List<T>> getFrameBuffer() {
    return frameBuffer;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}

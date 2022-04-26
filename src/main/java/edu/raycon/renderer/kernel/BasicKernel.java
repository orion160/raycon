package edu.raycon.renderer.kernel;

import edu.raycon.kernel.OnCompleteInvocationCallback;
import edu.raycon.kernel.kernel2d.Runnable2D;
import edu.raycon.renderer.Framebuffer;
import edu.raycon.renderer.presentation.PixelPresent;

public class BasicKernel implements Runnable2D<Framebuffer, PixelPresent> {

  @Override
  public void run(
      int i, int j, Framebuffer input, OnCompleteInvocationCallback<PixelPresent> callback) {
    var r = (double) i / (input.getHeight() - 1);
    var g = (double) j / (input.getWidth() - 1);
    var b = 1.0;
    var a = 1.0;

    var info = new PixelPresent(j, i, r, g, b, a);
    callback.onComplete(info);
  }
}

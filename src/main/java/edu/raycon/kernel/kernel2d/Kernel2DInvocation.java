package edu.raycon.kernel.kernel2d;

import edu.raycon.kernel.KernelRunnable;

public class Kernel2DInvocation extends KernelRunnable<Kernel2D> {

  private final int i;
  private final int j;

  public Kernel2DInvocation(Kernel2D kernel, int i, int j) {
    super(kernel);
    this.i = i;
    this.j = j;
  }

  @Override
  public void run() {
    kernel.run(i, j);
  }
}

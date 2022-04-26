package edu.raycon.kernel;

public abstract class KernelRunnable<T> implements Runnable {
  protected final T kernel;

  public KernelRunnable(T kernel) {
    this.kernel = kernel;
  }
}

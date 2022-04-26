package edu.raycon.kernel;

import edu.raycon.kernel.kernel2d.Runnable2D;
import edu.raycon.kernel.kernel2d.TaskData2D;

public abstract class Kernel<P, R> {
  protected final Runnable2D<P, R> task;

  protected final P input;

  protected final OnCompleteInvocationCallback<R> callback;

  public Kernel(TaskData2D<P, R> taskData2D) {
    this.task = taskData2D.getTask();
    this.input = taskData2D.getInput();
    this.callback = taskData2D.getCallback();
  }
}

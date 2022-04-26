package edu.raycon.kernel.kernel2d;

import edu.raycon.kernel.OnCompleteInvocationCallback;

public class TaskData2D<P, R> {
  private final Runnable2D<P, R> task;
  private final P input;
  private final OnCompleteInvocationCallback<R> callback;

  public TaskData2D(Runnable2D<P, R> task, P input, OnCompleteInvocationCallback<R> callback) {
    this.task = task;
    this.input = input;
    this.callback = callback;
  }

  public Runnable2D<P, R> getTask() {
    return task;
  }

  public P getInput() {
    return input;
  }

  public OnCompleteInvocationCallback<R> getCallback() {
    return callback;
  }
}

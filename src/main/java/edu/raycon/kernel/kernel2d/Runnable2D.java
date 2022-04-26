package edu.raycon.kernel.kernel2d;

import edu.raycon.kernel.OnCompleteInvocationCallback;

@FunctionalInterface
public interface Runnable2D<P, R> {
  void run(int i, int j, P input, OnCompleteInvocationCallback<R> callback);
}

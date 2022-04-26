package edu.raycon.kernel;

@FunctionalInterface
public interface OnCompleteInvocationCallback<T> {
  void onComplete(T output);
}

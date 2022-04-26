package edu.raycon.util;

public class MathCon {
  public static double clamp(double x, double min, double max) {
    if (x < min) {
      return min;
    }

    if (x > max) {
      return max;
    }

    return x;
  }
}

package edu.raycon.util;

public class RGBAColor {
  public double r;
  public double g;
  public double b;
  public double a;

  public RGBAColor(double r, double g, double b, double a) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
  }

  public RGBAColor plus(RGBAColor c) {
    this.r += c.r;
    this.g += c.g;
    this.b += c.b;
    this.a += c.a;

    return this;
  }

  public void clamp() {
    r = MathCon.clamp(r, 0.0, 1.0);
    g = MathCon.clamp(g, 0.0, 1.0);
    b = MathCon.clamp(b, 0.0, 1.0);
    a = MathCon.clamp(a, 0.0, 1.0);
  }
}

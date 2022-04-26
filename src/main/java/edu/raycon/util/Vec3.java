package edu.raycon.util;

import java.util.Arrays;

public class Vec3 {
  private final double[] v = new double[3];

  public Vec3() {
    v[0] = 0;
    v[1] = 0;
    v[2] = 0;
  }

  public Vec3(double x, double y, double z) {
    v[0] = x;
    v[1] = y;
    v[2] = z;
  }

  public static Vec3 plus(Vec3 lhs, Vec3 rhs) {
    return new Vec3(lhs.x() + rhs.x(), lhs.y() + rhs.y(), lhs.z() + rhs.z());
  }

  public static Vec3 negative(Vec3 vec3) {
    return new Vec3(-vec3.x(), -vec3.y(), -vec3.z());
  }

  public static Vec3 minus(Vec3 lhs, Vec3 rhs) {
    return new Vec3(lhs.x() - rhs.x(), lhs.y() - rhs.y(), lhs.z() - rhs.z());
  }

  public static Vec3 times(Vec3 vec3, double t) {
    return new Vec3(vec3.x() * t, vec3.y() * t, vec3.z() * t);
  }

  public static Vec3 elementwiseTimes(Vec3 lhs, Vec3 rhs) {
    return new Vec3(lhs.x() * rhs.x(), lhs.y() * rhs.y(), lhs.z() * rhs.z());
  }

  public static Vec3 divide(Vec3 vec3, double t) {
    return new Vec3(vec3.x() / t, vec3.y() / t, vec3.z() / t);
  }

  public static double length(Vec3 vec3) {
    return vec3.length();
  }

  public static double lengthSquared(Vec3 vec3) {
    return vec3.lengthSquared();
  }

  public static double dot(Vec3 lhs, Vec3 rhs) {
    return lhs.x() * rhs.x() + lhs.y() * rhs.y() + lhs.z() * rhs.z();
  }

  public static Vec3 cross(Vec3 lhs, Vec3 rhs) {
    return new Vec3(
        lhs.y() * rhs.z() - lhs.z() * rhs.y(),
        lhs.z() * rhs.x() - lhs.x() * rhs.z(),
        lhs.x() * rhs.y() - lhs.y() * rhs.x());
  }

  public static Vec3 normalize(Vec3 vec3) {
    return Vec3.divide(vec3, vec3.length());
  }

  public double x() {
    return v[0];
  }

  public double y() {
    return v[1];
  }

  public double z() {
    return v[2];
  }

  public double setX(double x) {
    return v[0] = x;
  }

  public double setY(double y) {
    return v[1] = y;
  }

  public double setZ(double z) {
    return v[2] = z;
  }

  public Vec3 plus(Vec3 vec3) {
    setX(x() + vec3.x());
    setY(y() + vec3.y());
    setZ(z() + vec3.z());

    return this;
  }

  public Vec3 negative() {
    setX(-x());
    setY(-y());
    setZ(-z());

    return this;
  }

  public Vec3 minus(Vec3 vec3) {
    setX(x() - vec3.x());
    setY(y() - vec3.y());
    setZ(z() - vec3.z());

    return this;
  }

  public Vec3 times(double t) {
    setX(x() * t);
    setY(y() * t);
    setZ(z() * t);

    return this;
  }

  public Vec3 elementwiseTimes(Vec3 vec3) {
    setX(x() * vec3.x());
    setY(y() * vec3.y());
    setZ(z() * vec3.z());

    return this;
  }

  public Vec3 divide(double t) {
    setX(x() / t);
    setY(y() / t);
    setZ(z() / t);

    return this;
  }

  public double length() {
    return Math.sqrt(lengthSquared());
  }

  public double lengthSquared() {
    return x() * x() + y() * y() + z() * z();
  }

  @Override
  public String toString() {
    return Arrays.toString(v);
  }
}

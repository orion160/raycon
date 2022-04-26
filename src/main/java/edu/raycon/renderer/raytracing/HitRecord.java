package edu.raycon.renderer.raytracing;

import edu.raycon.util.Ray;
import edu.raycon.util.Vec3;

public class HitRecord {
  public Vec3 p;
  public Vec3 normal;
  public double t;
  boolean front_face;

  public HitRecord() {
    this.p = new Vec3();
    this.normal = new Vec3();
  }

  public HitRecord(Vec3 p, Vec3 normal, double t) {
    this.p = p;
    this.normal = normal;
    this.t = t;
  }

  public void setFaceNormal(Ray r, Vec3 outwardNormal) {
    front_face = Vec3.dot(r.getDirection(), outwardNormal) < 0;
    normal = front_face ? outwardNormal : Vec3.negative(outwardNormal);
  }

  public void set(HitRecord record) {
    this.p = record.p;
    this.normal = record.normal;
    this.t = record.t;
    this.front_face = record.front_face;
  }
}

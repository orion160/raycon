package edu.raycon.renderer.raytracing;

import edu.raycon.util.Ray;

public interface Hittable {
  boolean hit(Ray r, double t_min, double t_max, HitRecord rec);
}

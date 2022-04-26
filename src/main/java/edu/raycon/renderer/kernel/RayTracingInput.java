package edu.raycon.renderer.kernel;

import edu.raycon.renderer.Camera;
import edu.raycon.renderer.Framebuffer;
import edu.raycon.renderer.raytracing.Hittable;

public record RayTracingInput(Camera camera, Framebuffer framebuffer, Hittable world, int samplesPerPixel) {
}

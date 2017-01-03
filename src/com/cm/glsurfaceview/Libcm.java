package com.cm.glsurfaceview;

public class Libcm {
	static {
		System.loadLibrary("cmopengl");
	}
	public static native void init();
	public static native void resize(int width, int height);
	public static native void render();
}

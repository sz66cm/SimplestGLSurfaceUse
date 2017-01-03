package com.cm.glsurfaceview;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private GLSurfaceView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new GLSurfaceView(MainActivity.this);
		view.setEGLContextClientVersion(2);
		//set the renderer
		view.setRenderer(new CMRenderer());
		setContentView(view);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		view.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		view.onResume();
	}
	
	class CMRenderer implements GLSurfaceView.Renderer {

		@Override
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
//			gl.glClearColor(0.5f, 0.5f, 1.0f, 1.0f);
			Libcm.init();
		}

		@Override
		public void onSurfaceChanged(GL10 gl, int width, int height) {
//			gl.glViewport(0, 0, width, height);
			Libcm.resize(width, height);
		}

		@Override
		public void onDrawFrame(GL10 gl) {
//			gl.glClear(gl.GL_COLOR_BUFFER_BIT);
			Libcm.render();
		}
		
	}
}

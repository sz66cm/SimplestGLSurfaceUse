#include <jni.h>
#include <android/log.h>
#include <GLES/gl.h>
#include <GLES/glext.h>

#define LOG_TAG "render.c"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)

void InitializeOpenGL();
void resizeViewport(jint, jint);
void renderFrame();

JNIEXPORT jint JNI_OnLoad(JavaVM* pVM, void* reserved) {
    LOGI("render.c JNI_OnLoad() start!");
    return JNI_VERSION_1_6;
}

JNIEXPORT void Java_com_cm_glsurfaceview_Libcm_init(JNIEnv* env, jobject thiz)
{
	LOGI("c init()");
	InitializeOpenGL();
}
JNIEXPORT void Java_com_cm_glsurfaceview_Libcm_resize(JNIEnv* env,
														jobject thiz,
														jint width,
														jint height)
{
	LOGI("c resize()");
	resizeViewport(width, height);
}
JNIEXPORT void Java_com_cm_glsurfaceview_Libcm_render(JNIEnv* env, jobject thiz)
{
	LOGI("c render()");
	renderFrame();
}

void InitializeOpenGL()
{
	glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
}

void resizeViewport(jint w, jint h)
{
	glViewport(0, 0, w, h);
}

void renderFrame()
{
	glClear(GL_COLOR_BUFFER_BIT);
}

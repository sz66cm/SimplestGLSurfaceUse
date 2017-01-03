LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := cmopengl
LOCAL_SRC_FILES := ./cmopengles/render.c
LOCAL_LDLIBS += -llog 
LOCAL_LDLIBS += -lGLESv2
# use GL ext model
LOCAL_CFLAGS += -DGL_GLEXT_PROTOTYPES


include $(BUILD_SHARED_LIBRARY)
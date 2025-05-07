#include <jni.h>
#include <stdio.h>
#include "testJni2.h"

JNIEXPORT jint JNICALL Java_testJni2_subtract(JNIEnv *env, jobject thisObj, jint n1, jint n2) {
    return n1 - n2;
}

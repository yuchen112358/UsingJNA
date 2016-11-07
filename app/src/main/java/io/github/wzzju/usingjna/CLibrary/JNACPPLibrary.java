package io.github.wzzju.usingjna.CLibrary;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * Created by yuchen on 16-11-7.
 */

public interface JNACPPLibrary extends Library {
    JNACPPLibrary INSTANCE = (JNACPPLibrary)
            Native.loadLibrary("demo", JNACPPLibrary.class);

    Pointer initialize(int a);

    void run(Pointer demo);

    int add(Pointer demo, int b);

    void finalize(Pointer demo);

    Pointer initializeString(String str);

    String substrString(Pointer demoString, int begin, int end);

    void finalizeString(Pointer demoString);
}

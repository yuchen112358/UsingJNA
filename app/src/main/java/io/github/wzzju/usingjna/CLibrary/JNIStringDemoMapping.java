package io.github.wzzju.usingjna.CLibrary;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * Created by netiger on 12/23/15.
 */
public interface JNIStringDemoMapping extends Library {
    JNIStringDemoMapping INSTANCE = (JNIStringDemoMapping)
            Native.loadLibrary("demo", JNIStringDemoMapping.class);

    Pointer initializeString(String str);

    String substrString(Pointer demoString, int begin, int end);

    void finalizeString(Pointer demoString);
}

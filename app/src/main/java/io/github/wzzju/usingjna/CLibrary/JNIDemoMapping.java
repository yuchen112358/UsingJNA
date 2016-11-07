package io.github.wzzju.usingjna.CLibrary;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * Created by netiger on 12/23/15.
 */
public interface JNIDemoMapping extends Library {
    JNIDemoMapping INSTANCE = (JNIDemoMapping)
            Native.loadLibrary("demo", JNIDemoMapping.class);

    Pointer initialize(int a);

    void run(Pointer demo);

    int add(Pointer demo, int b);

    void finalize(Pointer demo);


}

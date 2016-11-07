package io.github.wzzju.usingjna;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.sun.jna.Pointer;

import io.github.wzzju.usingjna.CLibrary.JNACPPLibrary;
import io.github.wzzju.usingjna.CLibrary.JNIDemoMapping;
import io.github.wzzju.usingjna.CLibrary.JNIStringDemoMapping;
import io.github.wzzju.usingjna.CLibrary.JPCNNLibrary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    int addRes = JPCNNLibrary.INSTANCE.add(6, 60);
//                    String str = String.valueOf(addRes);

                    String strDis = "5 + 6 = ";
                    strDis += Integer.toString(JNACalculateFunction(5, 6));

                    String strDisplay = JNASubstr("1234567890", 3, 5);
                    Snackbar.make(view, strDis+" subString = " + strDisplay, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        });
    }

    public static int JNACalculateFunction(int a, int b) {
        Pointer demo = JNACPPLibrary.INSTANCE.initialize(a);
        int c = JNACPPLibrary.INSTANCE.add(demo, b);
        JNACPPLibrary.INSTANCE.finalize(demo);
        return c;
    }

    public static String JNASubstr(String oriString, int begin, int end) {
        Pointer demo = JNACPPLibrary.INSTANCE.initializeString(oriString);
        String ret = JNACPPLibrary.INSTANCE.substrString(demo, begin, end);
        JNACPPLibrary.INSTANCE.finalizeString(demo);
        return ret;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

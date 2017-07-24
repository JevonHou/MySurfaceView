package com.nicai.mysurfaceview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MySurfaceView mySurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mySurfaceView = new MySurfaceView(this);
        setContentView(mySurfaceView);
    }
}

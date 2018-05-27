package com.jojo.tinkerpatchdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tinkerpatch.sdk.TinkerPatch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        tv.setText("load tinker patch successful !!!");
    }
    public void requestPatch(View v) {
        TinkerPatch.with().fetchPatchUpdate(true);
    }
}

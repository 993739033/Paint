package com.app.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private Button Btn_Reset;
    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn_Reset = (Button) findViewById(R.id.Reset);
        myView = (MyView) findViewById(R.id.myview);
        Btn_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myView.Reset();
            }
        });
    }
}

package com.example.tugofwar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    Button bp1 = (Button) findViewById(R.id.bp1);
    Button bp2 = (Button) findViewById(R.id.bp2);
    String st1;
    String st2;

    Button start = (Button) findViewById(R.id.s_button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        st1 = getIntent().getExtras().getString("pl1");
        st2 = getIntent().getExtras().getString("pl2");

        bp1.setOnClickListener(null);
        bp2.setOnClickListener(null);

        bp1.setText(st1);
        bp2.setText(st2);

//        start.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                bp1.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                    }
//                });
//                bp2.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                    }
//                });
//                start.setVisibility(v.GONE);
//                String s = "3";
//
//
//            }
//        });
    }

}

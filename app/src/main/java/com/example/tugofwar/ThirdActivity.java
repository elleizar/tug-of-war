package com.example.tugofwar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    Button bp1;
    Button bp2;
    String st1;
    String st2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        bp1 = (Button) findViewById(R.id.bp1);
        bp2 = (Button) findViewById(R.id.bp2);

        bp1.setEnabled(false);
        bp2.setEnabled(false);

        st1 = getIntent().getExtras().getString("pl1");
        st2 = getIntent().getExtras().getString("pl2");

        bp1.setText(st1);
        bp2.setText(st2);

        final Button s_button = (Button) findViewById(R.id.s_button);
        s_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bp1.setEnabled(true);
                bp2.setEnabled(true);
                s_button.setVisibility(View.INVISIBLE);
            }
        });

//        public void onClick()


    }

}

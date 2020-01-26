package com.example.tugofwar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    public Button bp1;
    public Button bp2;
    public String st1;
    public String st2;
    public ImageView i;
    public TextView message;
    public TextView score_mess;
    public Button s_button;
    public Button c_button;
    public Integer sp1;
    public Integer sp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        bp1 = (Button) findViewById(R.id.bp1);
        bp2 = (Button) findViewById(R.id.bp2);
        i = (ImageView) findViewById(R.id.ball);
        message = (TextView) findViewById(R.id.mess);
        score_mess = (TextView) findViewById(R.id.score);
        s_button = (Button) findViewById(R.id.s_button);
        c_button = (Button) findViewById(R.id.c_button);

        bp1.setEnabled(false);
        bp2.setEnabled(false);

        c_button.setVisibility(View.INVISIBLE);

        st1 = getIntent().getExtras().getString("pl1");
        st2 = getIntent().getExtras().getString("pl2");

        if (!st1.isEmpty()){
            bp1.setText(st1);
        }
        if (!st2.isEmpty()){
            bp2.setText(st2);
        }

        sp1 = 0;
        sp2 = 0;

        RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)
                i.getLayoutParams();
        par.leftMargin = 505;
        par.rightMargin = 0;

        s_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bp1.setEnabled(true);
                bp2.setEnabled(true);
                s_button.setVisibility(View.INVISIBLE);
                c_button.setVisibility(View.INVISIBLE);
                message.setText(getString(R.string.mess_tie));
                RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)
                        i.getLayoutParams();
                par.leftMargin = 505;
                par.rightMargin= 0;
            }
        });

        c_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSecondActivity();
            }
        });
    }

    public void goToSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.bp1:
            {
                RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)
                i.getLayoutParams();
                par.leftMargin -= 60;
                if (par.leftMargin <= 25){
                    message.setText(getString(R.string.mess_go, bp1.getText()));
                    sp1 += 1;
                    score_mess.setText(getString(R.string.mess_score, sp1, sp2));
                    bp1.setEnabled(false);
                    bp2.setEnabled(false);
                    s_button.setText(getString(R.string.again));
                    s_button.setVisibility(v.VISIBLE);
                    c_button.setVisibility(v.VISIBLE);
                }
                else if (par.leftMargin < 505) {
                    message.setText(getString(R.string.mess_win, bp1.getText()));
                }
                else if (par.leftMargin == 505){
                    message.setText(getString(R.string.mess_tie));
                }
                else {
                    message.setText(getString(R.string.mess_win, bp2.getText()));
                }


                break;
            }
            case R.id.bp2:
            {
                RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)
                i.getLayoutParams();
                par.leftMargin += 60;
                if (par.leftMargin >= 985){
                    message.setText(getString(R.string.mess_go, bp2.getText()));
                    sp2 += 1;
                    score_mess.setText(getString(R.string.mess_score, sp1, sp2));
                    bp1.setEnabled(false);
                    bp2.setEnabled(false);
                    s_button.setText("AGAIN");
                    s_button.setVisibility(v.VISIBLE);
                    c_button.setVisibility(v.VISIBLE);
                }
                else if (par.leftMargin > 505) {
                    message.setText(getString(R.string.mess_win, bp2.getText()));
                }
                else if (par.leftMargin == 505){
                    message.setText(getString(R.string.mess_tie));
                }
                else {
                    message.setText(getString(R.string.mess_win, bp1.getText()));
                }

                break;
            }

        }
    }

}

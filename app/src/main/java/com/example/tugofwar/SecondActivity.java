package com.example.tugofwar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    public Button enter_button;
    public EditText p1;
    public EditText p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        enter_button = (Button) findViewById(R.id.enter_button);
        p1 = (EditText) findViewById(R.id.p1);
        p2 = (EditText) findViewById(R.id.p2);
        enter_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToThirdActivity(p1, p2);
            }
        });
    }
    private void goToThirdActivity(EditText p1, EditText p2){
        Intent intent = new Intent(this, ThirdActivity.class);

        intent.putExtra("pl1", p1.getText().toString());
        intent.putExtra("pl2", p2.getText().toString());

        startActivity(intent);
    }
}

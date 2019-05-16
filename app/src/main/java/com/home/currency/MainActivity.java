package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText ed_ntd;
    Button btn_go;
    String temp,result="test",title="test";
    DecimalFormat df = new DecimalFormat("##.0000");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=ed_ntd.getText().toString();
                if(temp.compareTo("")==0) {
                    title="Problem";
                    result = "Please Enter Your NTD Amount!";
                }
                else {
                    title="Result";
                    result = "USD is " + df.format(Double.parseDouble(temp)/30.9);
                }

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(title)
                        .setMessage(result)
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
    }

    private void findviews(){
        ed_ntd=findViewById(R.id.ed_ntd);
        btn_go=findViewById(R.id.btn_go);

    }
}

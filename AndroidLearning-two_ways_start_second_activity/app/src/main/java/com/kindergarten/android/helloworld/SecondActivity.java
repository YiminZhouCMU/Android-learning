package com.kindergarten.android.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button btn;
    private String content = "Hi, I am page 2.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /**
         * send back result to the first page
         * data: intent object
         */
        btn = (Button)findViewById(R.id.sendback);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("sendbackinformation", content);
                setResult(2, data);

                //destoy this page
                finish();
            }
        });

    }
}

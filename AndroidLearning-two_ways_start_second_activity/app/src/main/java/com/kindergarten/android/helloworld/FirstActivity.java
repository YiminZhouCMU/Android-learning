package com.kindergarten.android.helloworld;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private TextView displayarea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btn1 = (Button)findViewById(R.id.firststart);
        btn2 = (Button)findViewById(R.id.secondstart);
        displayarea = (TextView)findViewById(R.id.result);

        /**
         * start another activity by using startActivity()
         */
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstway = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(firstway);
            }
        });


        /**
         * start another activity by using startActivityForResult
         */
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondway = new Intent(FirstActivity.this, SecondActivity.class);
                /**
                 * first argument: intent
                 * second argument: request code
                 */
                startActivityForResult(secondway, 1);
            }
        });
    }


    /**
     *
     * @param requestCode mark the button which sends the request
     * @param resultCode mark the page which sends back the information
     * @param data the data from the information resource(second page)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            String result = data.getStringExtra("sendbackinformation");
            displayarea.setText(result);
        }
    }
}

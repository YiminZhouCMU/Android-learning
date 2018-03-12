package com.kindergarten.android.helloworld;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox dog;
    private CheckBox cat;
    private CheckBox rabbit;
    private CheckBox hamster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // bound the layout xml file with activity.
        setContentView(R.layout.activity_main);

        dog = (CheckBox)findViewById(R.id.checkBox);
        cat = (CheckBox)findViewById(R.id.checkBox2);
        rabbit = (CheckBox)findViewById(R.id.checkBox3);
        hamster = (CheckBox)findViewById(R.id.checkBox4);

        dog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i("tag", "dog check box is changing");
                if (b) {
                    // get the text from checked box
                    String dogText = dog.getText().toString();
                    Log.i("tag", dogText);
                }
            }
        });


    }


}


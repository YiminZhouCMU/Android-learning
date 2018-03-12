package com.kindergarten.android.helloworld;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private ToggleButton tb;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // bound the layout xml file with activity.
        setContentView(R.layout.activity_main);

        tb = (ToggleButton)findViewById(R.id.toggleButton);
        image = (ImageView)findViewById(R.id.imageView);

        tb.setOnCheckedChangeListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            image.setBackgroundResource(R.mipmap.sev);
        } else {
            image.setBackgroundResource(R.mipmap.defaultuser);
        }

    }
}


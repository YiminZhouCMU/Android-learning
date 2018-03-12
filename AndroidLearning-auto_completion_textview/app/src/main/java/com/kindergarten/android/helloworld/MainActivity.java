package com.kindergarten.android.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView acText;
    private MultiAutoCompleteTextView macText;
    private String[] simpleList = {"Kelly", "Fiorenza", "Ellen", "Kate"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // bound the layout xml file with activity.
        setContentView(R.layout.activity_main);


        // 1. initialize component;
        // 2. adapter;
        // 3. initialize data resource;
        // 4. bound adapter and the autocompletetextview component together
        acText = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, simpleList);
        acText.setAdapter(adapter);


        // 1. initialize component;
        // 2. adapter;
        // 3. initialize data resource;
        // 4. bound adapter and the autocompletetextview component together
        // 5. set the tokenizer
        macText = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);
        macText.setAdapter(adapter);

        // use comma as tokenizer;
        macText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }
}


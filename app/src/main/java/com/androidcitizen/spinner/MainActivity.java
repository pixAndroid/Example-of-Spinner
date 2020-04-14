package com.androidcitizen.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextView txtHelloWorld;
    private Spinner spinnerTextSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHelloWorld = findViewById(R.id.txt_hello_world);
        spinnerTextSize = findViewById(R.id.spinnerTextSize);

        spinnerTextSize.setOnItemSelectedListener(this);

        String[] textSizes = getResources().getStringArray(R.array.font_sizes);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, textSizes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTextSize.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinnerTextSize) {
            String valueFromSpinner = parent.getItemAtPosition(position).toString();
            txtHelloWorld.setTextSize(Float.parseFloat(valueFromSpinner));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

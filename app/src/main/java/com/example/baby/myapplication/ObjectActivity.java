package com.example.baby.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectActivity extends AppCompatActivity {

    String name = null;
    int figureSize = 0;
    int color = 0;
    int lineSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        Button button = (Button)findViewById(R.id.button);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
        final Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);

        name = spinner.getSelectedItem().toString();
        figureSize = Integer.parseInt(spinner2.getSelectedItem().toString());

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout2);
        final MyView myView = new MyView(this, name, figureSize, lineSize);
        linearLayout.addView(myView);

        final Intent i = getIntent();
        final List<Figure> list = (ArrayList) i.getSerializableExtra("listObject");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                name = spinner.getSelectedItem().toString();
                myView.changeData(name, figureSize, lineSize);
                myView.invalidate();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                figureSize = Integer.parseInt(spinner2.getSelectedItem().toString());
                myView.changeData(name, figureSize, lineSize);
                myView.invalidate();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                color = Integer.parseInt(spinner3.getSelectedItem().toString());
                myView.changeData(name, figureSize, lineSize);
                myView.invalidate();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                lineSize = Integer.parseInt(spinner4.getSelectedItem().toString());
                myView.changeData(name, figureSize, lineSize);
                myView.invalidate();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //Log.d(this.getClass().getName(), list.size() + "");

        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                if (name != null && figureSize > 0 && color > 0 && lineSize > 0) {

                    list.add(new Figure(name, figureSize, color, lineSize));
                    i.putExtra("listObject", (Serializable) list);
                    setResult(RESULT_OK, i);
                    finish();
                } else {
                    String emptyInfo = "";

                    if (name == null)   emptyInfo = "도형 종류";
                    else if (figureSize == 0)   emptyInfo = "도형 크기";
                    else if (color == 0)   emptyInfo = "색상";
                    else if (lineSize == 0)   emptyInfo = "선 굵기";

                    Log.d(this.getClass().getName(), emptyInfo);

                    Toast toast = Toast.makeText(getApplicationContext(), emptyInfo + " 정보를 선택하지 않았습니다", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        Log.d(this.getClass().getName(), list.size() + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}

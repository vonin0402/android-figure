package com.example.baby.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PrintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        ListView listView = (ListView)findViewById(R.id.listView);

        Intent i = getIntent();
        final List<Figure> list = (ArrayList) i.getSerializableExtra("listObject");
        FigureAdapter figureAdapter = new FigureAdapter((ArrayList<Figure>) list);
        listView.setAdapter(figureAdapter);
        for (Figure figure : list) {
            figure.printData();
        }
    }
}

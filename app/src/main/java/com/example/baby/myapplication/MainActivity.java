package com.example.baby.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<Figure> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonObj = (Button)findViewById(R.id.button);
        Button buttonPrint = (Button)findViewById(R.id.button2);
        list = new ArrayList<Figure>();

        buttonObj.setOnClickListener(this);
        buttonPrint.setOnClickListener(this);
//
//        final ArrayList<String> arrList = new ArrayList<String>();
//        final ArrayAdapter <String> arrAdapter;
//        arrAdapter =  new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1, arrList);
//        listView.setAdapter(arrAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Log.d(this.getClass().getName(), list.size() + "");
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.button:
                i = new Intent(this, ObjectActivity.class);
                i.putExtra("listObject", (Serializable) list);
                startActivityForResult(i, 1);
                break;
            case R.id.button2:
                i = new Intent(this, PrintActivity.class);
                i.putExtra("listObject", (Serializable) list);
                startActivityForResult(i, 2);
                break;
        }
    }


    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            Intent i = data;
            list = (ArrayList)i.getSerializableExtra("listObject");
            Log.d(this.getClass().getName(), list.size() + "");
        }
    }
}


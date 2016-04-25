package com.example.baby.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Baby on 2016-04-18.
 */
public class FigureAdapter extends BaseAdapter {

    private ArrayList<Figure> a_list;

    public FigureAdapter(ArrayList <Figure> list) {
        a_list = list;
    }

    @Override
    public int getCount() {
        return a_list.size();
    }

    @Override
    public Object getItem(int position) {
        return a_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        final int positionData = position;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.figure_item, parent, false);
            Figure fi = a_list.get(position);
            if (fi != null) {
                TextView textView = (TextView)convertView.findViewById(R.id.textView);
                TextView textView2 = (TextView)convertView.findViewById(R.id.textView2);
                TextView textView3 = (TextView)convertView.findViewById(R.id.textView3);
                TextView textView4 = (TextView)convertView.findViewById(R.id.textView4);
                if (textView != null)   textView.setText("도형 : " + fi.getName());
                if (textView2 != null)   textView2.setText("크기 : " + fi.getFigureSize());
                if (textView3 != null)   textView3.setText("색상 : " + fi.getColor());
                if (textView4 != null)   textView4.setText("선 굵기 : " + fi.getLineSize());
            }
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, (positionData + 1) + " 번째 클릭", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context, ObjectActivity.class);
                    i.putExtra("listObject", (Serializable) a_list);
                    context.startActivity(i);
                }
            });
        }
        return convertView;
    }


}

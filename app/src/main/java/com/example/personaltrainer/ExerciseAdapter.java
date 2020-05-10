package com.example.personaltrainer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {
Context context;
List<Exercise> objects;


    public ExerciseAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Exercise> objects) {
        super(context, resource, textViewResourceId, objects);

        this.context=context;
        this.objects=objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=((Activity)context).getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.workout_listview,parent,false);

        TextView exName = (TextView)view.findViewById(R.id.exName);
        TextView exDescription = (TextView)view.findViewById(R.id.exDescription);
        TextView exReps = (TextView)view.findViewById(R.id.exReps);
        ImageView ivEx=(ImageView)view.findViewById(R.id.ivEx);
        Exercise temp = objects.get(position);


        ivEx.setImageBitmap(temp.getBitmap());
        exReps.setText(String.valueOf(temp.getReps()));
        exName.setText(temp.getName());
        exDescription.setText(temp.getDescription());

        return view;
    }
}

package com.example.personaltrainer.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.personaltrainer.Exercise;
import com.example.personaltrainer.ExerciseAdapter;
import com.example.personaltrainer.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ListView lvWorkout;
    ArrayList<Exercise> exerciseList;
    ExerciseAdapter exerciseAdapter;
    HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_workout, container, false);
        lvWorkout=(ListView) v.findViewById(R.id.lvWorkout);

        Exercise ex1 = new Exercise(20,"Sit-Ups","easy",null);
        Exercise ex2 = new Exercise(30,"Reverse-Crunches","easy-medium",null);
        Exercise ex3 = new Exercise(40,"Flutter-Kicks","hard",null);
        Exercise ex4 = new Exercise(40,"Bicycle-Crunches","hard",null);

        exerciseList = new ArrayList<Exercise>();
        exerciseList.add(ex1);exerciseList.add(ex2);exerciseList.add(ex3);
        exerciseList.add(ex4);

        exerciseAdapter =new ExerciseAdapter(getActivity(),0,0,exerciseList);
        lvWorkout.setAdapter(exerciseAdapter);




        return v;
    }
}
package io.github.taimoor.workoutTrainer.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.taimoor.workoutTrainer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlanOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlanOne extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_underweight_plan, container, false);
    }
}
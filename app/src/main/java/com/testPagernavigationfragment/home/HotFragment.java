package com.testPagernavigationfragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.testPagernavigationfragment.R;

import androidx.fragment.app.Fragment;

public class HomeFragment_Hot extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dic_layout_hot, container, false);
        return view;
    }
}

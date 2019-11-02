package com.testPagernavigationfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment_Hot extends Fragment implements View.OnClickListener{
    private TextView dic_hot_textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dic_layout_hot, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dic_hot_textView = (TextView) getActivity().findViewById(R.id.dic_hot_textView);
        Button button=(Button)getActivity().findViewById(R.id.dic_hot_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.dic_hot_button:{
                dic_hot_textView.setText("更新hot");
                Toast.makeText(getActivity(), "hot", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }
}

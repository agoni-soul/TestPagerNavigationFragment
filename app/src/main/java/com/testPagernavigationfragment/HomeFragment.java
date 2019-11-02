package com.testPagernavigationfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener{
    private Button android;
    private Button hot;
    private Button info;
    private ViewPager dic_viewPager;

    private MenuItem menuItem;
    private ArrayList<View> dic_ArrayList;
    private MyPagerAdapter mAdapter;

    //fragment
    private HomeFragment_Android homeFragment_android;
    private HomeFragment_Hot homeFragment_hot;
    private HomeFragment_Info homeFragment_info;
    private Fragment[] fragments;
    private int lastfragment;

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dic_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        android = (Button) getActivity().findViewById(R.id.android);
        hot = (Button) getActivity().findViewById(R.id.hot);
        info = (Button) getActivity().findViewById(R.id.info);

        dic_viewPager = (ViewPager) getActivity().findViewById(R.id.dic_viewpager);
        setupViewPager(dic_viewPager);

        android.setOnClickListener(this);
        hot.setOnClickListener(this);
        info.setOnClickListener(this);

        textView = (TextView) getActivity().findViewById(R.id.dic_textView);
        Button button=(Button)getActivity().findViewById(R.id.dic_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.dic_button:{
                textView.setText("第一个Fragment");
                Toast.makeText(getActivity(), "主页", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.android:
                dic_viewPager.setCurrentItem(0);
                Toast.makeText(getActivity(), "android", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hot:
                dic_viewPager.setCurrentItem(1);
                Toast.makeText(getActivity(), "hot", Toast.LENGTH_SHORT).show();
                break;
            case R.id.info:
                dic_viewPager.setCurrentItem(2);
                Toast.makeText(getActivity(), "info", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        menuItem.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    private void setupViewPager(ViewPager viewPager) {
        dic_ArrayList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        dic_ArrayList.add(li.inflate(R.layout.dic_layout_android,null,false));
        dic_ArrayList.add(li.inflate(R.layout.dic_layout_hot,null,false));
        dic_ArrayList.add(li.inflate(R.layout.dic_layout_info,null,false));
        mAdapter = new MyPagerAdapter(dic_ArrayList);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);
    }

    private void initFragment()
    {
        homeFragment_android = new HomeFragment_Android();
        homeFragment_hot = new HomeFragment_Hot();
        homeFragment_info = new HomeFragment_Info();
        fragments = new Fragment[]{homeFragment_android, homeFragment_hot, homeFragment_info};
        lastfragment = 0;
//        FragmentTransaction transaction = getSuppo
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.viewpager, homeFragment_android)
//                .show(homeFragment_android)
//                .commitAllowingStateLoss();
    }
}

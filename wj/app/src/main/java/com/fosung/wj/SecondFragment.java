package com.fosung.wj;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {

    private TextView tv_content;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        tv_content = view.findViewById(R.id.tv_content);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        //本地存储读取
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String string =  sharedPreferences.getString(getString(R.string.fragment1_text) ,"defult");
        tv_content.setText(string);
    }
}

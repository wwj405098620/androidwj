package com.fosung.wj;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FirstFragment extends Fragment implements View.OnClickListener {

    OnEditTextViewDoneListener listener;
    EditText editText;
    Button btn_send;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_first,container,false);
        editText =  view.findViewById(R.id.edit_1);
        btn_send = view.findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);
        return view;

    }


    public interface OnEditTextViewDoneListener {
        public void  OnEditTextViewDone(String text);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnEditTextViewDoneListener) activity;

        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement method OnSearchBtnClickedListener");
        }
    }

    @Override
    public void onClick(View view) {
        String string = editText.getText().toString();
        listener.OnEditTextViewDone(string);

        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("fragment1_text",string);
        editor.commit();

    }

}

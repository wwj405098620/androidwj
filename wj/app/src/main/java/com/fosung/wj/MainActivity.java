package com.fosung.wj;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,FirstFragment.OnEditTextViewDoneListener{
    private FirstFragment fragment_1;
    private SecondFragment fragment_2;
    private ThirdFragment fragment_3;
    private TextView tv_hello;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater  = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("main");
        initViews();


    }


    private void initViews(){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        FirstFragment fragment = new FirstFragment();
        fragmentTransaction.add(R.id.layout_fragment_first,fragment);
        fragmentTransaction.commit();


        TextView tv_first = findViewById(R.id.tv_first);
        TextView tv_second = findViewById(R.id.tv_second);
        TextView tv_third = findViewById(R.id.tv_third);
        tv_first.setOnClickListener(this);
        tv_second.setOnClickListener(this);
        tv_third.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        Fragment fragment = null;
        switch (view.getId()){
            case R.id.tv_first:{
                fragment = getFragment(0);
            }
            break;
            case R.id.tv_second:{
                fragment = getFragment(1);
            }
            break;
            case R.id.tv_third:{
                fragment = getFragment(2);
            }
            break;
            default:break;
        }
        transaction.replace(R.id.layout_fragment_first,fragment);
        transaction.commit();
    }

    private Fragment getFragment(int position) {

        if (position == 0){
            if (null == fragment_1){
                fragment_1 = new FirstFragment();
            }
            return fragment_1;
        }
        if (position == 1){

            if (null == fragment_2){
                fragment_2 = new SecondFragment();
            }
            return fragment_2;
        }
        if (position == 2){
            if (null == fragment_3){
                fragment_3 = new ThirdFragment();
            }
            return fragment_3;
        }
        return null;
    }


    public void goMain2(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("title","main2");
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:break;
            case  R.id.action_settings:break;
            default: return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void OnEditTextViewDone(String text) {
        TextView textView = findViewById(R.id.tv_hello);
        textView.setText(text);
    }
}

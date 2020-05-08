package com.fosung.wj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.fosung.wj.adapter.MainFragmentsAdapter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,FirstFragment.OnEditTextViewDoneListener{
    private FirstFragment fragment_1;
    private SecondFragment fragment_2;
    private ThirdFragment fragment_3;
    private TextView tv_hello;
    private ViewPager paper;
    private MainFragmentsAdapter adapter;


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

        // FragmentTransaction required的fragment 与viewpager required的fragment版本冲突 不能同时使用
        FragmentManager manager = getSupportFragmentManager();
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


        paper = findViewById(R.id.paper);
        adapter = new MainFragmentsAdapter(getSupportFragmentManager());
        paper.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_first:{
                paper.setCurrentItem(0);
            }
            break;
            case R.id.tv_second:{
                paper.setCurrentItem(1);
            }
            break;
            case R.id.tv_third:{
                paper.setCurrentItem(2);
            }
            break;
            default:break;
        }
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



    public void goUi(View view) {
    }
}

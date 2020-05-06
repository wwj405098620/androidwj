package com.fosung.wj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        setTitle(title);
    }
}

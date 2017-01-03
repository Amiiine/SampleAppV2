package com.amiine.sampleappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the button simple fields is clicked*/
    public void startSimpleFields(View view){
        Intent intent = new Intent(MainActivity.this,SimpleFieldsActivity.class);
        startActivity(intent);
    }
}

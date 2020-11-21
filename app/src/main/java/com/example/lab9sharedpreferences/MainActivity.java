package com.example.lab9sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Window window;

    Button mBtnGreen;
    Button mBtnOrange;
    Button mBtnBrown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnGreen = (Button) findViewById(R.id.btn_green);
        mBtnOrange = (Button) findViewById(R.id.btn_orange);
        mBtnBrown = (Button) findViewById(R.id.btn_brown);

        this.window = getWindow();

        mBtnGreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark ="#00BFA5";
                String primary = "#004D40";
                String background= "#009688";
                cambiarColor(primaryDark,primary,background);
            }
        });
        mBtnOrange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark = "#FF6D00";
                String primary = "#E65100";
                String background= "#FF9800";
                cambiarColor(primaryDark,primary,background);            }
        });

        mBtnBrown.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark = "#3E2723";
                String primary = "#8D6E63";
                String background= "#795548";
                cambiarColor(primaryDark,primary,background);            }
        });
    }

    private void cambiarColor(String primaryDark,String primary,String background){
        //ColorPrimaryDark
        window.setStatusBarColor(Color.parseColor(primaryDark));
        //ColorPrimary
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        //bg
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        //Botton navigation
        window.setNavigationBarColor(Color.parseColor(primary));

        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("color",Color.parseColor(primaryDark));
        mEditor.apply();

    }
}
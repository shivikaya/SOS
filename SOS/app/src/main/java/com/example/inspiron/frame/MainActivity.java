package com.example.inspiron.frame;

 import android.content.Intent;
 import android.graphics.Color;
 import android.support.v4.app.FragmentManager;
 import android.support.v4.app.FragmentTransaction;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main );
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction  ft= fm.beginTransaction();
        ft.replace(R.id.top ,new two());
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        ft.commit();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setTextColor(Color.parseColor("#517cd8"));
                b2.setTextColor(Color.parseColor("#111111"));
                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.replace(R.id.top, new One());
                two f = new two();
                ft1.hide(f);
                ft1.commit();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setTextColor(Color.parseColor("#517cd8") );
                b1.setTextColor(Color.parseColor("#111111") );
                FragmentManager fm2 = getSupportFragmentManager();
                FragmentTransaction ft2 = fm2.beginTransaction();
               // One f1=new One();
              //  ft2.hide(f1);
                ft2.replace(R.id.top, new two());
                ft2.commit();
            }
        });

    } }




package com.example.inspiron.frame;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowWork extends AppCompatActivity {
    ListView lv;
    DB adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_work);
        adapter=new DB(this);
        lv=(ListView)findViewById(R.id.listView2);
        ArrayList<String> a=new ArrayList<>();
        Cursor c=adapter.showAllRecords();
        while(c.moveToNext()) {
            a.add("Name: "+c.getString(0)+"\n\t" + c.getString(1));

        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a);
        lv.setAdapter(arrayAdapter);
    }

}

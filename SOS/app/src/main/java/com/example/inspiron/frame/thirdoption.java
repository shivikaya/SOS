package com.example.inspiron.frame;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class thirdoption extends Fragment {

    TextView t1,t2,t3;
    DB adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.thirdoption, container, false);
        adapter=new DB(v.getContext());
        Bundle b = getArguments();
        String uname = b.getString("uname");
        Cursor c=adapter.searchById(uname);
        t1=(TextView)v.findViewById(R.id.name);
        t1.setText(c.getString(0).toString());
        t2=(TextView)v.findViewById(R.id.pass);
        t2.setText(c.getString(1).toString());
        t3=(TextView)v.findViewById(R.id.pno);
        t3.setText(c.getString(2).toString());

//        Intent in = new Intent(v.getContext(),ShowWork.class);
//        startActivity(in);
        return v;
    }

}






























package com.example.inspiron.frame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class fourthoption extends Fragment {

    ListView lv;
    DB adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fourthoption, container, false);
        Intent in = new Intent(v.getContext(),Discover.class);
        startActivity(in);
        return v;
    }

}






























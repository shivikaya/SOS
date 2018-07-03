package com.example.inspiron.frame;;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class One extends Fragment {

    Button b1;
    DB adapter;
    EditText e1,e2,e3;
    String uname,pass,pno;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout. fragment_one , container, false);
        e1=(EditText)v.findViewById(R.id.ed1);
        e2=(EditText)v.findViewById(R.id.ed2);
        e3=(EditText)v.findViewById(R.id.ed3);
        b1 =(Button)v.findViewById(R.id.disp );
        adapter=new DB(v.getContext());
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                uname=e1.getText().toString();
                pass=e2.getText().toString();
                pno=e3.getText().toString();
                long l=adapter.insertData(uname,pass,pno);
                if(l>0)
                {
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");

                    Intent in = new Intent(v.getContext(),SecondActivity.class);
                    in.putExtra("user",uname);
                    in.putExtra("pno",pno);
                    startActivity(in);
                } else {
                    Toast.makeText(v.getContext(), "Error Occured", Toast.LENGTH_LONG).show();
                }

                          }
        });
        return v;
    }
}
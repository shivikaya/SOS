package com.example.inspiron.frame;;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

public class two extends Fragment {

    Button b1;
    EditText e4,e5;
    String uname,pass;
    DB adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout. fragment_two , container, false);

        b1 =(Button)v.findViewById(R.id. disp );
        e4 =(EditText)v.findViewById(R.id.ed4 );
        e5 =(EditText)v.findViewById(R.id.ed5);
        adapter=new DB(v.getContext());
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                uname=e4.getText().toString();
                pass=e5.getText().toString();
                boolean flag=adapter.validate(uname,pass);
                if(flag==true)
                {

                    Cursor c=adapter.searchById(uname);
                    Intent in = new Intent(v.getContext(),SecondActivity.class);
                    in.putExtra("user",uname);
                    in.putExtra("pno",c.getString(2).toString());
                    startActivity(in);
                    //startActivity(new Intent(this,HomeActivity.class));
                }
                else
                {
                    Toast.makeText(v.getContext(),"invalid USER",Toast.LENGTH_LONG).show();
                    //MyDialog.showDialog(this,"INVALID USERNAME OR PASSWORD");
                }
                          }
        });
        return v;
    }
}
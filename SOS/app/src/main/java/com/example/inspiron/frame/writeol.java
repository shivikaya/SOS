package com.example.inspiron.frame;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class writeol extends Fragment {

    Button b1,b2;
    EditText e4;
    String uname,ol;
    DB adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.writeol, container, false);
        Bundle b = getArguments();
        uname = b.getString("uname");
        b1 =(Button)v.findViewById(R.id.anb1);
        b2 =(Button)v.findViewById(R.id.unb1);
        e4 =(EditText)v.findViewById(R.id.edol1);

        adapter=new DB(v.getContext());
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                ol=e4.getText().toString();

                long l=adapter.insertData1(uname, ol);
                if(l>0)
                {
                    e4.setText("");

                    Toast.makeText(v.getContext(), "Submitted Successfully", Toast.LENGTH_LONG).show();
                    //Intent in = new Intent(v.getContext(),writeol.class);
                    //startActivity(in);
                } else {
                    Toast.makeText(v.getContext(), "Error Occured", Toast.LENGTH_LONG).show();
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                ol=e4.getText().toString();
                String an="anonymous";
                long l=adapter.insertData1(an, ol);
                if(l>0)
                {
                    e4.setText("");

                    Toast.makeText(v.getContext(), "Submitted Successfully", Toast.LENGTH_LONG).show();
                    //Intent in = new Intent(v.getContext(),writeol.class);
                    //startActivity(in);
                } else {
                    Toast.makeText(v.getContext(), "Error Occured", Toast.LENGTH_LONG).show();
                }

            }
        });
        return v;
    }

}


























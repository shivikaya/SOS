package com.example.inspiron.frame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class DB
{
    MyData helper;
    Context context;
    DB(Context context){
        this.context=context;
        helper=new MyData(context);
    }

    public Cursor searchById(String un)
    {
        SQLiteDatabase db=helper.getWritableDatabase();
        String whereClause=MyData.USERNAME+" = ?";
        String whereArgs[]={String.valueOf(un)};
        Cursor c=db.query(MyData.TABLE_NAME, null, whereClause, whereArgs, null, null,null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;


    }

    public Cursor showAllRecords(){
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor c=db.query(MyData.TABLE_NAME_1,null,null,null,null,null,null);

        return c;
    }
    public boolean validate(String username, String password)
    {
        boolean state=false;
        SQLiteDatabase db=helper.getWritableDatabase();

        String col[]={MyData.USERNAME,MyData.PASSWORD};
        String whereClause=MyData.USERNAME+" = ? and "+MyData.PASSWORD+" = ?";
        String whereArgs[]={username,password};
        Cursor c=db.query(MyData.TABLE_NAME,col,whereClause,whereArgs,null,null,null);
        if(c.moveToNext()) //moving the cursor to the next row to check if the cursor has any data or not
        {
            state=true;
        }
        return state;
    }

    public long insertData(String username,String password,String PNO)
    {
        //Getting Instance of SQLite Database Class
        SQLiteDatabase db=helper.getWritableDatabase();
        //Inserting data into table
        ContentValues values=new ContentValues();

        values.put(MyData.USERNAME,username);
        values.put(MyData.PASSWORD,password);
        values.put(MyData.PHONE_NUMBER,PNO);



        long l=db.insert(MyData.TABLE_NAME,null,values);
        return l;
    }

    public long insertData1(String username,String ol)
    {
        //Getting Instance of SQLite Database Class
        SQLiteDatabase db=helper.getWritableDatabase();
        //Inserting data into table
        ContentValues values=new ContentValues();

        values.put(MyData.USERNAME,username);
        values.put(MyData.OPEN_LETTER,ol);




        long l=db.insert(MyData.TABLE_NAME_1,null,values);
        return l;
    }

    class MyData extends SQLiteOpenHelper
    {
        private static  final String DB_NAME="safe";
        private static final int DB_VERSION=1;
        private static final String TABLE_NAME="userdetails";
        private static final String TABLE_NAME_1="openletters";
        private static final String USERNAME="username";
        private static final String PASSWORD="password";
        private static final String PHONE_NUMBER="pno";
        private static final String OPEN_LETTER="ol";

        //QUERY FOR CREATE TABLE
        private static final String TABLE_CREATE="create table if not exists "+TABLE_NAME+" ("+USERNAME+"  varchar(20) ,"+PASSWORD+"  varchar(20), "+PHONE_NUMBER+" varchar(10));";
        private static final String TABLE_CREATE_1="create table if not exists "+TABLE_NAME_1+" ("+USERNAME+"  varchar(20) ,"+OPEN_LETTER+"  varchar(100));";
        private static final String TABLE_DROP="drop table "+TABLE_NAME;

        public MyData(Context context) {
            super(context, DB_NAME, null, DB_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE_1);
            db.execSQL(TABLE_CREATE);

        }



        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(TABLE_DROP);
            onCreate(db);
        }
    }
}

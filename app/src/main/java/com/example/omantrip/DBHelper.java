package com.example.omantrip;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // here I created database and table inside it with 4 colum
    public static final String DATABASE_NAME="trips.db";
    public static final String TABLE_NAME="trip";
    public static final String COL_1="numed";
    public static final String COL_2="id860";
    public static final String COL_3="nameed";
    public static final String COL_4="car860";

    public DBHelper(netrip netrip)
    {

        super(netrip,DATABASE_NAME,null,1);
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " +TABLE_NAME+ "(numed TEXT,id860 TEXT,nameed TEXT,car860 TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //here I get all user data to the DB table
    public boolean insertData(String numed, String id860, String nameed, String car860)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues cval=new ContentValues();
        cval.put(COL_1,numed);
        cval.put(COL_2,id860);
        cval.put(COL_3,nameed);
        cval.put(COL_4,car860);
        long result=db.insert(TABLE_NAME,null,cval);
        if(result==-1)
            return false;
        else
            return true;

    }

    //update method to let user update the data
    public boolean updateData(String numed, String id860, String nameed, String car860) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cval=new ContentValues();
        cval.put(COL_1,numed);
        cval.put(COL_2,id860);
        cval.put(COL_3,nameed);
        cval.put(COL_4,car860);
        db.update(TABLE_NAME,cval,"id860=?",new String[]{id860});
        return true;

    }

    //in this method all user data can be deleted
    public Integer deleteData(String id860) {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id860=?",new String[]{id860});

    }


    //through this method all data displayed
    public Cursor getAllData() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from " +TABLE_NAME,null);
        return cursor;

    }

}

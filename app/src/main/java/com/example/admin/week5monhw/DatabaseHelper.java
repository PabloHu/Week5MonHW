package com.example.admin.week5monhw;

/**
 * Created by Admin on 9/25/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/6/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    List<ContactObj> contactObjList=new ArrayList<>();

    private static final String DATABASE_NAME="myDatabase";
    private static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="contacts";

    public static final String KIWI_ID ="ID";
    public static final String KIWI_NAME ="Name";
    public static final String KIWI_PHONE ="Phone";
    public static final String KIWI_TIMESTAMP ="TimeStamp";
    private static final String TAG = "DatabaseTAG";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("+
                KIWI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KIWI_NAME + " CHAR(50) NOT NULL," +
                KIWI_PHONE + " CHAR(50)," +
                KIWI_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"+
                ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);

        autoFillData(sqLiteDatabase);


    }

    public void autoFillData(SQLiteDatabase sqLiteDatabase){
        ContentValues values = new ContentValues();
        values.put(KIWI_NAME, "one");
        values.put(KIWI_PHONE, "03803854");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(KIWI_NAME, "two");
        values.put(KIWI_PHONE, "03803854");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(KIWI_NAME, "something");
        values.put(KIWI_PHONE, "03803854");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(KIWI_NAME, "four");
        values.put(KIWI_PHONE, "03803854");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(KIWI_NAME, "something");
        values.put(KIWI_PHONE, "03803854");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long createDB(String name, String phone ){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(KIWI_NAME, name);
        contentValues.put(KIWI_PHONE, phone);
        //contentValues.put(KIWI_LASTNAME,lastName);
        //contentValues.put(KIWI_CELL,cell);
        //contentValues.put(KIWI_NOTE,note);

        //sqLiteDatabase.insert(TABLE_NAME,null,contentValues);//null is if you are passing no values
        long rowNumber = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        Log.d(TAG, "saveNewContact: "+rowNumber);
        return rowNumber;
    }

    public Cursor readDB(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

return cursor;


    }
    public void updateDB(int id, String name, String phone){

        Log.d(TAG, "updateKiwi id: " + id);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "UPDATE "+ TABLE_NAME+ " SET " + KIWI_NAME+ " = '"+ name +
                " "+ KIWI_PHONE +" = '" + phone+
                "' WHERE " + KIWI_ID + " = " + id;

        try {
            sqLiteDatabase.execSQL(query);
            Log.d(TAG, "updateKiwi work");
        }
        catch (Exception e){
            Log.d(TAG, "updateKiwi err: " + e.toString());
        }


    }

}

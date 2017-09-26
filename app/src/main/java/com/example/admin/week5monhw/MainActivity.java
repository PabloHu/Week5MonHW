package com.example.admin.week5monhw;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String KIWI_NAME ="Name";
    public static final String KIWI_PHONE ="Phone";
    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    public static final String TAG = "MainActivityTag";
    private static final String AUTHORITY = "com.example.admin.week5monhw.ContactsProvider";
    private static final String BASE_PATH = "contacts";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper starterDB = new DatabaseHelper(this);
        //starterDB.createDB("hi","4343");
        starterDB.readDB();

        Uri contentURI = CONTENT_URI;

        //String name = "Name";

        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);

        while(cursor.moveToNext()){
            String result = cursor.getString(cursor.getColumnIndex(KIWI_NAME));
            Log.d("TAG", "DB: " + result);
        }
    }




}
package com.example.requestapp;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String KIWI_NAME ="Name";
    public static final String KIWI_PHONE ="Phone";
    private static final String CAR_OPTIONS_FRAGMENT_TAG = "FRAG1";
    ContactObj contactObj;
    public static final String TAG = "MainActivityTag";
    private static final String AUTHORITY = "com.example.admin.week5monhw.ContactsProvider";
    private static final String BASE_PATH = "contacts";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );
    Uri contentURI = CONTENT_URI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);

        List<ContactObj> contactObjList = new ArrayList<>();

        while(cursor.moveToNext()){
            contactObj = new ContactObj();


            String dbGetName = cursor.getString(cursor.getColumnIndex(KIWI_NAME));
            String dbGetPhone = cursor.getString(cursor.getColumnIndex(KIWI_PHONE));

            contactObj.setName(dbGetName);
            contactObj.setPhone(dbGetPhone);

            contactObjList.add(contactObj);

//            Log.d("TAG", "DBreq: " + result);


        }
        for (int i = 0; i <contactObjList.size() ; i++) {
            Log.d(TAG, "onCreate: "+contactObjList.get(i).getName() + " " + contactObjList.get(i).getPhone());

        }

        RequestAppFragment requestAppFragment  = RequestAppFragment.newInstance(contactObjList);
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragHolderCarOptions, requestAppFragment, CAR_OPTIONS_FRAGMENT_TAG)
                .addToBackStack(CAR_OPTIONS_FRAGMENT_TAG)

                .commit();

    }


}

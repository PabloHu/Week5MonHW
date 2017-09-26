package com.example.admin.week5monhw;

/**
 * Created by Admin on 9/25/2017.
 */


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

public class ContactsProvider extends ContentProvider {

    private static final String AUTHORITY = "com.example.admin.week5monhw.ContactsProvider";
    private static final String BASE_PATH = "contacts";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

    private static final int CONTACTS = 1;
    //private static final int CONTACT_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(AUTHORITY,BASE_PATH, CONTACTS);
       // uriMatcher.addURI(AUTHORITY,BASE_PATH + "/#",CONTACT_ID);
    }

    //private SQLiteDatabase database;
    DatabaseHelper databaseHelper;


    @Nullable
    @Override
    public String getType(Uri uri) {

        switch (uriMatcher.match(uri)) {
            case CONTACTS:
                return "vnd.android.cursor.dir/vnd.com.example.admin.week5monhw/contacts";
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new DatabaseHelper(getContext());
        //database = helper.getWritableDatabase(t);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Cursor cursor;

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
  cursor=sqLiteDatabase.query("Contacts", strings, s, strings1, null, null,s1);
        cursor.setNotificationUri(
                getContext().getContentResolver(),CONTENT_URI);
//        cursor.setNotificationUri(getContext().getContentResolver(),uri);

        return cursor;
    }



    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
      /*  long id = database.insert(DatabaseHelper.TABLE_CONTACTS,null,contentValues);

        if (id > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, id);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        */
        throw new SQLException("Insertion Failed for URI :" + uri);

    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {

        /*
        int delCount = 0;
        switch (uriMatcher.match(uri)) {
            case CONTACTS:
                delCount =  database.delete(DatabaseHelper.TABLE_CONTACTS,s,strings);
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        */
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        /*
        int updCount = 0;
        switch (uriMatcher.match(uri)) {
            case CONTACTS:
                updCount =  database.update(DatabaseHelper.TABLE_CONTACTS,contentValues,s,strings);
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        */
        return 0;
    }
}
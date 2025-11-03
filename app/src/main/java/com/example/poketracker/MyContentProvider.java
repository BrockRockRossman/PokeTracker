package com.example.poketracker;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import java.net.URI;

public class MyContentProvider extends ContentProvider {

    private MainDatabaseHelper mHelper;
    public final static String DBNAME = "pokeDB";
    public final static String TABLE_NAME = "TaskTable";



    public static final String COL_NATNUM = "Natnum";
    public static final String COL_NAME = "Name";
    public static final String COL_SPECIES = "Species";
    public static final String COL_GENDER = "Gender";
    public static final String COL_HEIGHT = "Height";
    public static final String COL_WEIGHT = "Weight";
    public static final String COL_LEVEL = "Level";
    public static final String COL_HP = "HP";
    public static final String COL_ATTACK = "Attack";
    public static final String COL_DEFENSE = "Defense";

    private final static String SQL_CREATE_MAIN =
            "CREATE TABLE TaskTable (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NATNUM + " INTEGER, " +
                    COL_NAME + " TEXT, " +
                    COL_SPECIES + " TEXT, " +
                    COL_GENDER + " TEXT, " +
                    COL_HEIGHT + " DOUBLE, " +
                    COL_WEIGHT + " DOUBLE, " +
                    COL_LEVEL + " INTEGER, " +
                    COL_HP + " INTEGER, " +
                    COL_ATTACK + " INTEGER, " +
                    COL_DEFENSE + " INTEGER)";


    public static final Uri CONTENT_URI = Uri.parse("content://com.example.poketracker.provider");

    protected final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);

        }
        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

        }
    }

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return mHelper.getWritableDatabase().
                delete(TABLE_NAME, selection,
                        selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        String Natnum = values.getAsString(COL_NATNUM);
        String Name = values.getAsString(COL_NAME);
        String Species = values.getAsString(COL_SPECIES);
        String gender = values.getAsString(COL_GENDER);
        String Weight = values.getAsString(COL_WEIGHT);
        String Height = values.getAsString(COL_HEIGHT);
        String Level = values.getAsString(COL_LEVEL);
        String HP = values.getAsString(COL_HP);
        String Attack = values.getAsString(COL_ATTACK);
        String Defense = values.getAsString(COL_DEFENSE);

        long id = mHelper.getWritableDatabase().insert(TABLE_NAME, null, values);

        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }

    @Override
    public boolean onCreate() {
        mHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return mHelper.getReadableDatabase().query(TABLE_NAME, null, selection, selectionArgs, null, null, sortOrder);
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return mHelper.getWritableDatabase().
                update(TABLE_NAME, values, selection,
                        selectionArgs);
    }
}
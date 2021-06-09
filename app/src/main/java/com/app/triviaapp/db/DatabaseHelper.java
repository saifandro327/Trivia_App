package com.app.triviaapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.triviaapp.model.HistoryModel;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
DatabaseHelper databaseHelper;
    private static final String DB_NAME = "gamedb";
Context context;
    // database version
    private static final int DB_VERSION = 1;

    // table name.
    private static final String TABLE_NAME = "gameshistory";

    // id column.
    private static final String ID_COL = "id";

    // username name column
    private static final String UNAME = "name";

    // answer1 column.
    private static final String Answer1 = "answer1";

    // answer2 column.
    private static final String Answer2 = "answer2";

    // DateandTime column.
    private static final String DateandTime = "dateandtime";



    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UNAME + " TEXT,"
                + Answer1 + " TEXT,"
                + Answer2 + " TEXT,"
                + DateandTime + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }


    // this method is use to add new game to  database.
    public void addNewGame(String name, String answer1, String answer2, String dateandtime) {





        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();


        values.put(UNAME, name);
        values.put(Answer1, answer1);
        values.put(Answer2, answer2);
        values.put(DateandTime, dateandtime);

        // after adding all values we are passing content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our database after adding database.
        db.close();
    }

    public ArrayList<HistoryModel> getgamesHistory() {
        ArrayList<HistoryModel> arrayList = new ArrayList<>();

        // select all query
        String select_query= "SELECT *FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HistoryModel noteModel = new HistoryModel();
                noteModel.setId(cursor.getString(0));
                noteModel.setDateandtime(cursor.getString(1));
                noteModel.setName(cursor.getString(2));
                noteModel.setAnswer1(cursor.getString(3));
                noteModel.setAnswer2(cursor.getString(4));

                arrayList.add(noteModel);
            }while (cursor.moveToNext());
        }
        return arrayList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

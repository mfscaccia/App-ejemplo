package com.challengeappmarceloscaccia.com.myapplication.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChallengeDBhelper extends SQLiteOpenHelper {
    public static String DB_NAME = "challenge.sqlite";
    private static final int DB_VERSION = 1;
    public static String CREATE_TABLE_BUDGETS = "CREATE TABLE budgets(_id INTEGER PRIMARY KEY AUTOINCREMENT, descripcion TEXT," +
            "subcategoria TEXT, nombre TEXT, Email text, telefono TEXT, localizacion TEXT)";

    public ChallengeDBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

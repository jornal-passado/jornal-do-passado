package com.example.throwback;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {


    //Context
    private Context context;

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Version
    private static final String DATABASE_NAME = "arquivopt.db";

    //Table Name
    private static final String TABLE_NAME = "news_data";

    //Table Fields
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_HEADLINE = "headline";
    private static final String COLUMN_ULR = "url";
    private static final String COLUMN_DATE = "date";

    private static String CSV_PATH;
    private static final String CSV_FILE = "all_news_extracted.csv";
    private static final String CSV_SPLIT_BY = "\t";




    SQLiteDatabase database;

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID int NOT NULL," +
                COLUMN_ID + " int NOT NULL," +
                COLUMN_HEADLINE + " varchar(255) NOT NULL," +
                COLUMN_ULR + " varchar(255) NOT NULL," +
                COLUMN_DATE + " DATE NOT NULL," +
                " PRIMARY KEY(ID))");
        
        List<Headline> headlines = get_all_headlines();

        for (Headline headline: headlines){
            ContentValues values = new ContentValues();
            values.put(COLUMN_HEADLINE, headline.getHeadline());
            values.put(COLUMN_ULR, headline.getUrl());
            values.put(COLUMN_DATE, headline.getDate());

            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(TABLE_NAME, null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private List<Headline> get_all_headlines() {

        List<Headline> headlineCollection = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.context.getAssets().open(CSV_FILE)))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] lineNewsInfo = line.split(CSV_SPLIT_BY);

                String headline = lineNewsInfo[3];
                String url = lineNewsInfo[5];
                String date = lineNewsInfo[4];
                headlineCollection.add(new Headline(headline, url, date));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return headlineCollection;
    }

}

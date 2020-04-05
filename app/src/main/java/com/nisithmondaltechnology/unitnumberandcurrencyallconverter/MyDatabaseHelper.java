package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String databaseName = "converter_database.db";
    private static final int version = 1;



    public MyDatabaseHelper(Context context){
        super(context,MyDatabaseHelper.databaseName,null,version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Here table is Created
        final String createTableQuery = "CREATE TABLE "+ AllTables.ConvertHistory.tableName +"("+
                AllTables.ConvertHistory.columnId +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                AllTables.ConvertHistory.columnConvertionText +" VARCHAR(300) NOT NULL,"+
                AllTables.ConvertHistory.columnDate +" VARCHAR(50) NOT NULL,"+
                AllTables.ConvertHistory.columnTime +" VARCHAR(50) NOT NULL,"+
                AllTables.ConvertHistory.columnConvertionType +" VARCHAR(300) NOT NULL"+ ");";
        try {
            db.execSQL(createTableQuery);
        }catch (Exception e){}


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertDataToDatabase(String convertionText,String date,String time,String convertionType){
        boolean isSuccessfull = true;
        ContentValues contentValues = new ContentValues();
        contentValues.put(AllTables.ConvertHistory.columnConvertionText,convertionText);
        contentValues.put(AllTables.ConvertHistory.columnDate,date);
        contentValues.put(AllTables.ConvertHistory.columnTime,time);
        contentValues.put(AllTables.ConvertHistory.columnConvertionType,convertionType);
        SQLiteDatabase db = getWritableDatabase();
        long rowId = -1;
        try {
           rowId = db.insert(AllTables.ConvertHistory.tableName,null,contentValues);
        }catch (Exception e){

        }

        if (rowId == -1){
            isSuccessfull = false;
        }
        return isSuccessfull;
    }


    public Cursor getCursorObject(String convertionType){
        //This method return cursor object to select data from database
        SQLiteDatabase db = getWritableDatabase();
        String []selectedColumns = {AllTables.ConvertHistory.columnId,AllTables.ConvertHistory.columnConvertionText,AllTables.ConvertHistory.columnDate,
                                    AllTables.ConvertHistory.columnTime,AllTables.ConvertHistory.columnConvertionType};
        Cursor cursor = null;
        String []selectionArgs = {convertionType};
        try {
            cursor = db.query(AllTables.ConvertHistory.tableName,selectedColumns,AllTables.ConvertHistory.columnConvertionType +"=?",selectionArgs,null,null,AllTables.ConvertHistory.columnId +" DESC");
        }catch (Exception e){
        }



        return cursor;
    }


    public boolean deleteDataFromDatabase(int rowId){
        boolean isSuccessfull = false;
        SQLiteDatabase db = getWritableDatabase();
        int affectedrows = 0;
        try {
            affectedrows = db.delete(AllTables.ConvertHistory.tableName,AllTables.ConvertHistory.columnId +"="+rowId,null);
        }catch (Exception e){
            Log.d("DB",e.getMessage());

        }

        if (affectedrows>0){
            isSuccessfull = true;
        }
        return isSuccessfull;
    }



}

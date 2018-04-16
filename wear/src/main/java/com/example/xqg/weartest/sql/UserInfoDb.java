package com.example.xqg.weartest.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.xqg.weartest.bean.UserInfo;

/**
 * Created by xqg on 2017/9/2.
 */

public class UserInfoDb {
    private UserInfoDBHelper dbHelper;

    public UserInfoDb(Context context){
        dbHelper=new UserInfoDBHelper(context);
    }

    public int getCount(){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String queryString = "SELECT * from "+ UserInfo.tableName;
        Cursor cursor=db.rawQuery(queryString,null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public void deleteAll(){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.beginTransaction();
        db.delete(UserInfo.tableName,null,null);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }
    public void insert(String deviceId, int statusSit, int statusMood){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values=new ContentValues();
        values.put("device_id",deviceId);
        values.put("status_sit_long_call",statusSit);
        values.put("status_check_mood_call",statusMood);
        db.insertOrThrow(UserInfo.tableName, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();

    }
    public String getDeivceId(){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String queryString = "SELECT device_id from "+ UserInfo.tableName;
        Cursor cursor=db.rawQuery(queryString,null);
        cursor.moveToFirst();
        String deviceId = cursor.getString(cursor.getColumnIndex("device_id"));
        cursor.close();
        return deviceId;
    }

    public void setDeviceId(String deviceId){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("device_id",deviceId);
        db.update(UserInfo.tableName,values,null,null);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public int getStatusSitLongCall() {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String queryString = "SELECT status_sit_long_call from "+ UserInfo.tableName;
        Cursor cursor=db.rawQuery(queryString,null);
        cursor.moveToFirst();
        int status = cursor.getInt(cursor.getColumnIndex("status_sit_long_call"));
        cursor.close();
        return status;
    }

    public void setStatusSitLongCall(int status){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("status_sit_long_call",status);
        db.update(UserInfo.tableName,values,null,null);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public int getStatusCheckMoodCall() {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String queryString = "SELECT status_check_mood_call from "+ UserInfo.tableName;
        Cursor cursor=db.rawQuery(queryString,null);
        cursor.moveToFirst();
        int status = cursor.getInt(cursor.getColumnIndex("status_check_mood_call"));
        cursor.close();
        return status;
    }

    public void setStatusCheckMoodCall(int status){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("status_check_mood_call",status);
        db.update(UserInfo.tableName,values,null,null);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }
}

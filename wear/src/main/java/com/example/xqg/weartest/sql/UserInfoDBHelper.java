package com.example.xqg.weartest.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.xqg.weartest.bean.UserInfo;

/**
 * Created by xqg on 2017/9/2.
 */

public class UserInfoDBHelper extends SQLiteOpenHelper {

    //数据库版本号
    private static final int DATABASE_VERSION = 1;

    //数据库名称
    private static final String DATABASE_NAME="crud.db";

    public UserInfoDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//创建数据表
        String CREATE_TABLE_USER = "" +
                "CREATE TABLE " +UserInfo.tableName+
                "(device_id text, " + //设备的唯一标识
                " status_sit_long_call int, " +                   //是否设置久坐提醒
                " status_check_mood_call int);";                         //是否检测心情
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int i1) {
        //升级数据表

    }
}

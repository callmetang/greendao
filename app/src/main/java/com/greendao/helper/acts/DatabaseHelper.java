package com.greendao.helper.acts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import test.greendao.dao.BookDao;
import test.greendao.dao.DaoMaster;
import test.greendao.dao.DaoSession;
import test.greendao.dao.ImUserInfoDao;

/**
 * 数据库辅助工具
 * @author tang
 * @date 2019/1/30
 */

public class DatabaseHelper {
    private static final String DB_NAME = "db-name";

    private DaoSession daoSession;

    public DatabaseHelper(Context context) {
        try {
            DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
            SQLiteDatabase database = openHelper.getWritableDatabase();
            DaoMaster daoMaster = new DaoMaster(database);
            daoSession = daoMaster.newSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImUserInfoDao getUserInfoDao() {
        if (daoSession != null) {
            return null;
        }
        return daoSession.getImUserInfoDao();
    }

    public BookDao getBookDao() {
        if (daoSession != null) {
            return null;
        }
        return daoSession.getBookDao();
    }
}

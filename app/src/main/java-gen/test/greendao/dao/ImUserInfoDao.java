package test.greendao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import test.greendao.bean.ImUserInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ImUserTable".
*/
public class ImUserInfoDao extends AbstractDao<ImUserInfo, Long> {

    public static final String TABLENAME = "ImUserTable";

    /**
     * Properties of entity ImUserInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property UserId = new Property(1, String.class, "userId", false, "USER_ID");
        public final static Property UserName = new Property(2, String.class, "userName", false, "USER_NAME");
        public final static Property UserIcon = new Property(3, String.class, "userIcon", false, "USER_ICON");
        public final static Property Tag = new Property(4, String.class, "tag", false, "TAG");
        public final static Property UserRemarks = new Property(5, String.class, "userRemarks", false, "USER_REMARKS");
        public final static Property IsShield = new Property(6, Boolean.class, "isShield", false, "IS_SHIELD");
    };


    public ImUserInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ImUserInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ImUserTable\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"USER_ID\" TEXT NOT NULL ," + // 1: userId
                "\"USER_NAME\" TEXT," + // 2: userName
                "\"USER_ICON\" TEXT," + // 3: userIcon
                "\"TAG\" TEXT," + // 4: tag
                "\"USER_REMARKS\" TEXT," + // 5: userRemarks
                "\"IS_SHIELD\" INTEGER);"); // 6: isShield
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ImUserTable\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ImUserInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getUserId());
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(3, userName);
        }
 
        String userIcon = entity.getUserIcon();
        if (userIcon != null) {
            stmt.bindString(4, userIcon);
        }
 
        String tag = entity.getTag();
        if (tag != null) {
            stmt.bindString(5, tag);
        }
 
        String userRemarks = entity.getUserRemarks();
        if (userRemarks != null) {
            stmt.bindString(6, userRemarks);
        }
 
        Boolean isShield = entity.getIsShield();
        if (isShield != null) {
            stmt.bindLong(7, isShield ? 1L: 0L);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ImUserInfo readEntity(Cursor cursor, int offset) {
        ImUserInfo entity = new ImUserInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // userId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // userName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // userIcon
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // tag
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // userRemarks
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0 // isShield
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ImUserInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserId(cursor.getString(offset + 1));
        entity.setUserName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUserIcon(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTag(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUserRemarks(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIsShield(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ImUserInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ImUserInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}

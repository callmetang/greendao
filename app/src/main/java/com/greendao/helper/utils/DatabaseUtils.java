package com.greendao.helper.utils;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * 创建表
 * 使用前修改outDir为你自己的电脑项目路径
 *
 * @author tang
 */
public class DatabaseUtils {
    public static void main(String[] args) throws Exception {

        int version = 1;
        String defaultPackage = "test.greendao.bean";
        //创建模式对象，指定版本号和自动生成的bean对象的包名
        Schema schema = new Schema(version, defaultPackage);
        //指定自动生成的dao对象的包名,不指定则都DAO类生成在"test.greenDAO.bean"包中
        schema.setDefaultJavaPackageDao("test.greendao.dao");

        //添加用户实体
        addUserEntity(schema);
        addBookEntity(schema);


        String outDir = "F:/my/demo/GreenDaoHelper/app/src/main/java-gen";
        //调用DaoGenerator().generateAll方法自动生成代码到之前创建的java-gen目录下
        new DaoGenerator().generateAll(schema, outDir);

    }

    private static void addUserEntity(Schema schema) {
//        //添加一个实体，则会自动生成实体Entity类
        Entity entity = schema.addEntity("ImUserInfo");
        //指定表名，如不指定，表名则为 Entity（即实体类名）
        entity.setTableName("ImUserTable");
        //给实体类中添加属性（即给test表中添加字段）
        entity.addIdProperty().autoincrement();//添加Id,自增长
        entity.addStringProperty("userId").notNull();
        entity.addStringProperty("userName");
        entity.addStringProperty("userIcon");
        entity.addStringProperty("tag");
        entity.addStringProperty("userRemarks");
        entity.addBooleanProperty("isShield");
    }

    private static void addBookEntity(Schema schema) {
//        //添加一个实体，则会自动生成实体Entity类
        Entity entity = schema.addEntity("Book");
        //指定表名，如不指定，表名则为 Entity（即实体类名）
        entity.setTableName("bookTable");
        //给实体类中添加属性（即给test表中添加字段）
        entity.addIdProperty().autoincrement();//添加Id,自增长
        entity.addStringProperty("bookid").notNull();//添加String类型的name,不能为空
        entity.addStringProperty("bookName");
    }
}

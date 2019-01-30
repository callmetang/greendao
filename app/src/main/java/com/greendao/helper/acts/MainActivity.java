package com.greendao.helper.acts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.greendao.helper.R;

import java.util.List;

import test.greendao.bean.ImUserInfo;
import test.greendao.dao.ImUserInfoDao;

/**
 * @author tang
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImUserInfoDao imUserInfoDao = new DatabaseHelper(this).getUserInfoDao();
        if (imUserInfoDao != null) {

            ImUserInfo user = createUser();

            imUserInfoDao.insert(user);
            List list = imUserInfoDao.loadAll();
            Log.d("MainActivity", "list:" + list);
        }

    }

    @NonNull
    private ImUserInfo createUser() {
        ImUserInfo user = new ImUserInfo();
        user.setIsShield(false);
        user.setUserIcon("UserIcon");
        user.setTag("Tag...Tag");
        user.setUserName("tang");
        user.setUserId("1001");
        user.setUserRemarks("UserRemarks");
        return user;
    }
}

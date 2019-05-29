package com.example.h0227.demo2.dbutils;

import com.example.h0227.demo2.app.App;
import com.example.h0227.demo2.bean.Person;
import com.test.dao.DaoMaster;
import com.test.dao.DaoSession;
import com.test.dao.PersonDao;

import java.util.ArrayList;
import java.util.List;

public class MyDb {
    private final PersonDao dao;

    private MyDb(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.getApp(), "person.db");
        DaoMaster master = new DaoMaster(helper.getWritableDb());
        DaoSession session = master.newSession();
        dao = session.getPersonDao();
    }
    private static MyDb myDb;

    public static MyDb getDb(){
        if (myDb == null){
            synchronized (MyDb.class){
                if (myDb == null){
                    myDb = new MyDb();
                }
            }
        }
        return myDb;
    }
    public void insertAll(ArrayList<Person> list){
        dao.insertOrReplaceInTx(list);
    }
    public List<Person> queryAll(){
        List<Person> list = dao.queryBuilder().list();
        return list;
    }
}

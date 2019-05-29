package com.example.h0227.demo2.model;

import com.example.h0227.demo2.bean.Person;
import com.example.h0227.demo2.contract.Contract;
import com.example.h0227.demo2.dbutils.MyDb;

import java.util.ArrayList;
import java.util.List;

public class Model implements Contract.Model {
    @Override
    public void getData(Contract.CallBack callBack) {
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Person(null,"今天心情不太美丽",Integer.valueOf(99+""+i)));
        }
        MyDb.getDb().insertAll(list);
        List<Person> all = MyDb.getDb().queryAll();
            callBack.succeed((ArrayList<Person>) all);
    }
}

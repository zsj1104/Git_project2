package com.example.h0227.demo2.contract;

import com.example.h0227.demo2.bean.Person;

import java.util.ArrayList;

public interface Contract {
    interface Model {
        void getData(CallBack callBack);
    }

    interface View {
        void succeed(ArrayList<Person> person);
        void falied(String s);
    }

    interface Presenter {
        void getData();
    }
    interface CallBack{
        void succeed(ArrayList<Person> person);
        void falied(String s);
    }
}

package com.example.h0227.demo2.presenter;

import com.example.h0227.demo2.bean.Person;
import com.example.h0227.demo2.contract.Contract;

import java.util.ArrayList;

public class Presenter implements Contract.Presenter, Contract.CallBack {
    private Contract.Model model;
    private Contract.View view;

    public Presenter(Contract.Model model, Contract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData() {
        model.getData(this);
    }

    @Override
    public void succeed(ArrayList<Person> person) {
        view.succeed(person);
    }

    @Override
    public void falied(String s) {
        view.falied(s);
    }
}

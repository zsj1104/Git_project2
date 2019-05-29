package com.example.h0227.demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.h0227.demo2.adapter.XrlAdapter;
import com.example.h0227.demo2.bean.Person;
import com.example.h0227.demo2.contract.Contract;
import com.example.h0227.demo2.dbutils.MyDb;
import com.example.h0227.demo2.model.Model;
import com.example.h0227.demo2.presenter.Presenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private XRecyclerView xrl;
    private List<Person> list;
    private XrlAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        new Presenter(new Model(),this).getData();
    }

    private void initView() {
        xrl = (XRecyclerView) findViewById(R.id.xrl);
        xrl.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new XrlAdapter(list, this);
        xrl.setAdapter(adapter);
    }

    @Override
    public void succeed(ArrayList<Person> person) {
        list.addAll(person);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void falied(String s) {

    }
}

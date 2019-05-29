package com.example.h0227.demo2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.h0227.demo2.R;
import com.example.h0227.demo2.bean.Person;

import org.w3c.dom.Text;

import java.util.List;

public class XrlAdapter extends RecyclerView.Adapter<XrlAdapter.ViewHolder> {
    private List<Person> list;
    Context context;

    public XrlAdapter(List<Person> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public XrlAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull XrlAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv1.setText(list.get(i).getName());
        viewHolder.tv2.setText(list.get(i).getAge()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv2;
        private final TextView tv1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}

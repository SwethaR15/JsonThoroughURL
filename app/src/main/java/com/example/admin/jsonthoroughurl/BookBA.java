package com.example.admin.jsonthoroughurl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BookBA extends BaseAdapter {
    Context context;
    List<BookGS> bookGSList;

    public BookBA(Context context,List<BookGS> bookGSList){

        this.context=context;
        this.bookGSList=bookGSList;

    }

    @Override
    public int getCount() {
        return bookGSList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View  cview = LayoutInflater.from(context).inflate(R.layout.texts, viewGroup, false);
        TextView name=cview.findViewById(R.id.position_name);
        name.setText(bookGSList.get(i).getPosName());

        TextView name2=cview.findViewById(R.id.location);
        name2.setText(bookGSList.get(i).getLocation());

        TextView name3=cview.findViewById(R.id.sal_range);
        name3.setText(bookGSList.get(i).getSalRange());

        TextView name4=cview.findViewById(R.id.key_skills);
        name4.setText(bookGSList.get(i).getKeySkills());

        TextView name5=cview.findViewById(R.id.exp);
        name5.setText(bookGSList.get(i).getExperience());


        view=cview;




        return view;
    }
}

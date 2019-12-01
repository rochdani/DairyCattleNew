package com.example.dairycattle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;



public class FarmList extends ArrayAdapter<Farm> {
    private Activity context;
    private List<Farm> farmList;

    public FarmList(Activity context, List<Farm> farmList) {
        super(context, R.layout.list_layout, farmList);
        this.context = context;
        this.farmList = farmList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewCattleName);
        TextView textViewRegNo = listViewItem.findViewById(R.id.textViewCattleId);

        Farm farm = farmList.get(position);
        textViewName.setText(farm.getFarmName());
        textViewRegNo.setText(farm.getFarmRegNo());


        return listViewItem;
    }
}



package com.example.dairycattle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CattleList extends ArrayAdapter<Cattle> {
    private Activity context;
    private List<Cattle> cattleList;

    public CattleList(Activity context, List<Cattle> cattleList) {
        super(context, R.layout.cattle_list, cattleList);
        this.context = context;
        this.cattleList = cattleList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.cattle_list, null, true);

        TextView textViewCattleTagID = listViewItem.findViewById(R.id.textViewCattleBreed);
        TextView textViewCattleSex = listViewItem.findViewById(R.id.textViewCattleId);

        Cattle cattle = cattleList.get(position);
        textViewCattleTagID.setText(cattle.getCattleTAGID());
        textViewCattleSex.setText(cattle.getCattleSex());


        return listViewItem;
    }
}
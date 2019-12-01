package com.example.dairycattle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class BreedingList extends ArrayAdapter<Breeding> {
    private Activity context;
    private List<Breeding> breedingList;

    public BreedingList(Activity context, List<Breeding> breedingList) {
        super(context, R.layout.breeding_list, breedingList);
        this.context = context;
        this.breedingList = breedingList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.breeding_list, null, true);

        TextView textViewBreedingID= listViewItem.findViewById(R.id.textViewBreedingID);
        TextView textViewBreedingSemenID = listViewItem.findViewById(R.id.textViewBreedingSemenID);
        TextView textViewBreedingDateofHeat = listViewItem.findViewById(R.id.textViewBreedingSemenID);
        TextView textViewBreeding = listViewItem.findViewById(R.id.textViewBreedingSemenID);
        TextView textViewBreedingSemenID = listViewItem.findViewById(R.id.textViewBreedingSemenID);
        TextView textViewBreedingSemenID = listViewItem.findViewById(R.id.textViewBreedingSemenID);
        TextView textViewBreedingSemenID = listViewItem.findViewById(R.id.textViewBreedingSemenID);
        TextView textViewBreedingSemenID = listViewItem.findViewById(R.id.textViewBreedingSemenID);
        TextView textViewBreedingSemenID = listViewItem.findViewById(R.id.textViewBreedingSemenID);
        TextView textViewBreedingSemenID = listViewItem.findViewById(R.id.textViewBreedingSemenID);
        TextView textViewBreedingSemenID = listViewItem.findViewById(R.id.textViewBreedingSemenID);

        Breeding breeding = breedingList.get(position);
        textViewBreedingID.setText(breeding.getBreedingID());
        textViewBreedingSemenID.setText(breeding.getBreedingSemenID());


        return listViewItem;
    }

}
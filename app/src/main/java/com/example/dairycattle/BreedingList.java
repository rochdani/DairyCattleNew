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
        TextView textViewBreedingDateofHeat = listViewItem.findViewById(R.id.textViewBreedingDateofHeat);
        TextView textViewBreedingDateofFAI = listViewItem.findViewById(R.id.textViewBreedingDateofFAI);
        TextView textViewBreedingDateofSAI = listViewItem.findViewById(R.id.textViewBreedingDateofSAI);
        TextView textViewBreedingVetCode= listViewItem.findViewById(R.id.textViewBreedingVetCode);
        TextView textViewBreedingDateofPD = listViewItem.findViewById(R.id.textViewBreedingDateofPd);
        TextView textViewBreedingDateofLastCal = listViewItem.findViewById(R.id.textViewBreedingDateofLC);
        TextView textViewBreedingNameofTech= listViewItem.findViewById(R.id.textViewBreedingDateofTech);
        TextView textViewBreedingNoofCal = listViewItem.findViewById(R.id.textViewBreedingNoofCal);
        TextView textViewBreedingAIRecpt = listViewItem.findViewById(R.id.textViewBreedingAIReceipt);

        Breeding breeding = breedingList.get(position);
        textViewBreedingID.setText(breeding.getBreedingID());
        textViewBreedingSemenID.setText(breeding.getBreedingSemenID());
        textViewBreedingDateofHeat.setText(breeding.getBreedingDateOfHeatSignObserved());
        textViewBreedingDateofFAI.setText(breeding.getBreedingDateOfFirstAI());
        textViewBreedingDateofSAI.setText(breeding.getBreedingDateOfSecondAI());
        textViewBreedingVetCode.setText(breeding.getBreedingVeterinarianCode());
        textViewBreedingDateofPD.setText(breeding.getBreedingDateOfPD());
        textViewBreedingDateofLastCal.setText(breeding.getBreedingDateOfLastCalving());
        textViewBreedingNameofTech.setText(breeding.getBreedingNameOfTechnnician());
        textViewBreedingNoofCal.setText(breeding.getBreedingNoOfCalving());
        textViewBreedingAIRecpt.setText(breeding.getBreedingAIReceiptNo());


        return listViewItem;
    }

}
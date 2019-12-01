package com.example.dairycattle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class DiseaseList extends ArrayAdapter<Disease> {
    private Activity context;
    private List<Disease> diseaseList;

    public DiseaseList(Activity context, List<Disease> diseaseList) {
        super(context, R.layout.disease_list, diseaseList);
        this.context = context;
        this.diseaseList = diseaseList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.disease_list, null, true);

        TextView textViewDiseaseDate= listViewItem.findViewById(R.id.textViewDiseaseDate);
        TextView textViewDiseaseID = listViewItem.findViewById(R.id.textViewDiseaseID);
       // TextView textViewCattleID = listViewItem.findViewById(R.id.textViewCattleId);
        TextView textViewClinical = listViewItem.findViewById(R.id.textViewDiseaseClinicalSign);
        TextView textViewTypeOfCS = listViewItem.findViewById(R.id.textViewDiseaseTypeOfCS);
        TextView textViewDiagnosis = listViewItem.findViewById(R.id.textViewDiseaseDiagnosis);
        TextView textViewTreatment = listViewItem.findViewById(R.id.textViewDiseaseTreatment);
        TextView textViewRemarks = listViewItem.findViewById(R.id.textViewDiseaseRemarks);
        TextView textViewNameofVet = listViewItem.findViewById(R.id.textViewDiseaseNameofVet);

        Disease disease = diseaseList.get(position);
        textViewDiseaseDate.setText(disease.getDiseaseDate());
        textViewDiseaseID.setText(disease.getDiseaseID());
       // textViewCattleID.setText(disease.getDiseaseCattleID());
        textViewClinical.setText(disease.getDiseaseClinicalSigns());
        textViewTypeOfCS.setText(disease.getDiseaseTypeOfClinicalSigns());
        textViewDiagnosis.setText(disease.getDiseaseDiagnosis());
        textViewTreatment.setText(disease.getDiseaseTreatment());
        textViewRemarks.setText(disease.getDiseaseRemarks());
        textViewNameofVet.setText(disease.getDiseaseNameOfVeterinarian());


        return listViewItem;
    }

}
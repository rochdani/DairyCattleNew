package com.example.dairycattle;

public class Disease {

    String DiseaseID;
    String DiseaseDate;
    String DiseaseCattleID;
    String DiseaseClinicalSigns;
    String DiseaseTypeOfClinicalSigns;
    String DiseaseDiagnosis;
    String DiseaseTreatment;
    String DiseaseRemarks;
    String DiseaseNameOfVeterinarian;

    public Disease() {

    }

    public Disease(String diseaseID, String diseaseDate, String diseaseCattleID, String diseaseClinicalSigns, String diseaseTypeOfClinicalSigns, String diseaseDiagnosis, String diseaseTreatment, String diseaseRemarks, String diseaseNameOfVeterinarian) {
        DiseaseID = diseaseID;
        DiseaseDate = diseaseDate;
        DiseaseCattleID = diseaseCattleID;
        DiseaseClinicalSigns = diseaseClinicalSigns;
        DiseaseTypeOfClinicalSigns = diseaseTypeOfClinicalSigns;
        DiseaseDiagnosis = diseaseDiagnosis;
        DiseaseTreatment = diseaseTreatment;
        DiseaseRemarks = diseaseRemarks;
        DiseaseNameOfVeterinarian = diseaseNameOfVeterinarian;
    }

    public String getDiseaseID() {
        return DiseaseID;
    }

    public String getDiseaseDate() {
        return DiseaseDate;
    }

    public String getDiseaseCattleID() {
        return DiseaseCattleID;
    }

    public String getDiseaseClinicalSigns() {
        return DiseaseClinicalSigns;
    }

    public String getDiseaseTypeOfClinicalSigns() {
        return DiseaseTypeOfClinicalSigns;
    }

    public String getDiseaseDiagnosis() {
        return DiseaseDiagnosis;
    }

    public String getDiseaseTreatment() {
        return DiseaseTreatment;
    }

    public String getDiseaseRemarks() {
        return DiseaseRemarks;
    }

    public String getDiseaseNameOfVeterinarian() {
        return DiseaseNameOfVeterinarian;
    }

    public void setDiseaseID(String diseaseID) {
        DiseaseID = diseaseID;
    }

    public void setDiseaseDate(String diseaseDate) {
        DiseaseDate = diseaseDate;
    }

    public void setDiseaseCattleID(String diseaseCattleID) {
        DiseaseCattleID = diseaseCattleID;
    }

    public void setDiseaseClinicalSigns(String diseaseClinicalSigns) {
        DiseaseClinicalSigns = diseaseClinicalSigns;
    }

    public void setDiseaseTypeOfClinicalSigns(String diseaseTypeOfClinicalSigns) {
        DiseaseTypeOfClinicalSigns = diseaseTypeOfClinicalSigns;
    }

    public void setDiseaseDiagnosis(String diseaseDiagnosis) {
        DiseaseDiagnosis = diseaseDiagnosis;
    }

    public void setDiseaseTreatment(String diseaseTreatment) {
        DiseaseTreatment = diseaseTreatment;
    }

    public void setDiseaseRemarks(String diseaseRemarks) {
        DiseaseRemarks = diseaseRemarks;
    }

    public void setDiseaseNameOfVeterinarian(String diseaseNameOfVeterinarian) {
        DiseaseNameOfVeterinarian = diseaseNameOfVeterinarian;
    }
}

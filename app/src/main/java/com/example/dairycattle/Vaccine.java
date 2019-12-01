package com.example.dairycattle;

public class Vaccine {

    String VaccineID;
    String CattleVaccineID;
    String VaccineDate;
    String VaccineClinicalSigns;
    String VaccineTypeOfClinicalSign;
    String VaccineKindOfDisease;
    String VaccineTreatment;
    String VaccineRemarks;
    String VaccineNameOfVeterinarian;

    public Vaccine() {

    }

    public Vaccine(String vaccineID, String cattleVaccineID, String vaccineDate, String vaccineClinicalSigns, String vaccineTypeOfClinicalSign, String vaccineKindOfDisease, String vaccineTreatment, String vaccineRemarks, String vaccineNameOfVeterinarian) {
        VaccineID = vaccineID;
        CattleVaccineID = cattleVaccineID;
        VaccineDate = vaccineDate;
        VaccineClinicalSigns = vaccineClinicalSigns;
        VaccineTypeOfClinicalSign = vaccineTypeOfClinicalSign;
        VaccineKindOfDisease = vaccineKindOfDisease;
        VaccineTreatment = vaccineTreatment;
        VaccineRemarks = vaccineRemarks;
        VaccineNameOfVeterinarian = vaccineNameOfVeterinarian;
    }

    public String getVaccineID() {
        return VaccineID;
    }

    public String getCattleVaccineID() {
        return CattleVaccineID;
    }

    public String getVaccineDate() {
        return VaccineDate;
    }

    public String getVaccineClinicalSigns() {
        return VaccineClinicalSigns;
    }

    public String getVaccineTypeOfClinicalSign() {
        return VaccineTypeOfClinicalSign;
    }

    public String getVaccineKindOfDisease() {
        return VaccineKindOfDisease;
    }

    public String getVaccineTreatment() {
        return VaccineTreatment;
    }

    public String getVaccineRemarks() {
        return VaccineRemarks;
    }

    public String getVaccineNameOfVeterinarian() {
        return VaccineNameOfVeterinarian;
    }


    public void setVaccineID(String vaccineID) {
        VaccineID = vaccineID;
    }

    public void setCattleVaccineID(String cattleVaccineID) {
        CattleVaccineID = cattleVaccineID;
    }

    public void setVaccineDate(String vaccineDate) {
        VaccineDate = vaccineDate;
    }

    public void setVaccineClinicalSigns(String vaccineClinicalSigns) {
        VaccineClinicalSigns = vaccineClinicalSigns;
    }

    public void setVaccineTypeOfClinicalSign(String vaccineTypeOfClinicalSign) {
        VaccineTypeOfClinicalSign = vaccineTypeOfClinicalSign;
    }

    public void setVaccineKindOfDisease(String vaccineKindOfDisease) {
        VaccineKindOfDisease = vaccineKindOfDisease;
    }

    public void setVaccineTreatment(String vaccineTreatment) {
        VaccineTreatment = vaccineTreatment;
    }

    public void setVaccineRemarks(String vaccineRemarks) {
        VaccineRemarks = vaccineRemarks;
    }

    public void setVaccineNameOfVeterinarian(String vaccineNameOfVeterinarian) {
        VaccineNameOfVeterinarian = vaccineNameOfVeterinarian;
    }
}

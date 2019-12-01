package com.example.dairycattle;

public class Farm {


    String FarmId;
    String FarmName;
    String FarmRegNo;
    String FarmOwnName;
    String FarmVetDiv;
    String FarmGSDiv;
    String FarmAddress;
    String FarmContactNo;
    String FarmCattleCount;
    String FarmDairyCattleCount;


    public Farm() {

    }

    public Farm(String farmId, String farmName, String farmRegNo, String farmOwnName, String farmVetDiv, String farmGSDiv, String farmAddress, String farmContactNo, String farmCattleCount, String farmDairyCattleCount) {
        FarmId = farmId;
        FarmName = farmName;
        FarmRegNo = farmRegNo;
        FarmOwnName = farmOwnName;
        FarmVetDiv = farmVetDiv;
        FarmGSDiv = farmGSDiv;
        FarmAddress = farmAddress;
        FarmContactNo = farmContactNo;
        FarmCattleCount = farmCattleCount;
        FarmDairyCattleCount = farmDairyCattleCount;
    }

    public String getFarmId() {
        return FarmId;
    }

    public String getFarmName() {
        return FarmName;
    }

    public String getFarmRegNo() {
        return FarmRegNo;
    }

    public String getFarmOwnName() {
        return FarmOwnName;
    }

    public String getFarmVetDiv() {
        return FarmVetDiv;
    }

    public String getFarmGSDiv() {
        return FarmGSDiv;
    }

    public String getFarmAddress() {
        return FarmAddress;
    }

    public String getFarmContactNo() {
        return FarmContactNo;
    }

    public String getFarmCattleCount() {
        return FarmCattleCount;
    }

    public String getFarmDairyCattleCount() {
        return FarmDairyCattleCount;
    }

    public void setFarmId(String farmId) {
        FarmId = farmId;
    }

    public void setFarmName(String farmName) {
        FarmName = farmName;
    }

    public void setFarmRegNo(String farmRegNo) {
        FarmRegNo = farmRegNo;
    }

    public void setFarmOwnName(String farmOwnName) {
        FarmOwnName = farmOwnName;
    }

    public void setFarmVetDiv(String farmVetDiv) {
        FarmVetDiv = farmVetDiv;
    }

    public void setFarmGSDiv(String farmGSDiv) {
        FarmGSDiv = farmGSDiv;
    }

    public void setFarmAddress(String farmAddress) {
        FarmAddress = farmAddress;
    }

    public void setFarmContactNo(String farmContactNo) {
        FarmContactNo = farmContactNo;
    }

    public void setFarmCattleCount(String farmCattleCount) {
        FarmCattleCount = farmCattleCount;
    }

    public void setFarmDairyCattleCount(String farmDairyCattleCount) {
        FarmDairyCattleCount = farmDairyCattleCount;
    }
}


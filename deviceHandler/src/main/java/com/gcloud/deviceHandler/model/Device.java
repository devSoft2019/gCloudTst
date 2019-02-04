package com.gcloud.deviceHandler.model;

public class Device {

    private long idDevice;
    private String macAdress;
    private long timestamp;

    public Device(){

    }

    public Device(long idDevice, String macAdress, long timestamp){
        this.idDevice = idDevice;
        this.macAdress = macAdress;
        this.timestamp = timestamp;
    }

    public long getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

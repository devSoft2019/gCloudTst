package com.gcloudapp.deviceHandler.model;

public class Device {

    private int idDevice;
    private String macAdress;
    private long timestamp;

    public Device(){

    }

    public Device(int idDevice, String macAdress, long timestamp){
        this.idDevice = idDevice;
        this.macAdress = macAdress;
        this.timestamp = timestamp;
    }

    public int getIdDevice() {
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

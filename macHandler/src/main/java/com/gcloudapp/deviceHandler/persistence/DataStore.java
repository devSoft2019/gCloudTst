package com.gcloudapp.deviceHandler.persistence;

import com.gcloudapp.deviceHandler.model.Device;

import java.sql.SQLException;
import java.util.List;

public interface DataStore {

    long saveDevice(Device device)throws SQLException;
    boolean isMacAdressPresent(String macAdress)throws SQLException;
    Device getDevice(String macAdress)throws SQLException;
    Device getDevice(int idDevice)throws SQLException;
    List<Device> getAllDevices()throws SQLException;
}

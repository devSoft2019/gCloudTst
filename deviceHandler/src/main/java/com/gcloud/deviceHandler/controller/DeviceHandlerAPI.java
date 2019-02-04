package com.gcloud.deviceHandler.controller;

import com.gcloud.deviceHandler.model.Device;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DeviceHandlerAPI {

    @PostMapping("/device")
    ResponseEntity saveDevice(@RequestBody Device device);
    @GetMapping("/device/macAdress")
    ResponseEntity<Device> getDeviceByMcAdress(@RequestParam("macAdress") String macAdress);
    @GetMapping("/device/id")
    ResponseEntity<Device> getDeviceByIdDevice(@RequestParam("idDevice") int idDevice);
    @GetMapping("/devices")
    ResponseEntity<List<Device>> getAllDevices();
}

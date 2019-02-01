package com.gcloudapp.deviceHandler.controller;

import com.gcloudapp.deviceHandler.model.Device;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DeviceHandlerAPI {

    @PostMapping("/device")
    ResponseEntity saveDevice(@RequestBody Device device);
    @GetMapping("/device")
    ResponseEntity<Device> getDevice(@RequestParam("macAdress") String macAdress);
    @GetMapping("/device")
    ResponseEntity<Device> getDevice(@RequestParam("idDevice") int idDevice);
    @GetMapping("/devices")
    ResponseEntity<List<Device>> getAllDevices();
}

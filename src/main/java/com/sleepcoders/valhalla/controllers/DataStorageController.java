package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.dataStorage.DataStorage;
import com.sleepcoders.valhalla.services.implementation.DataStorageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DataStorageController {

    private final DataStorageServices dataStorageServices;

    @Autowired
    public DataStorageController(DataStorageServices dataStorageServices) {
        this.dataStorageServices = dataStorageServices;
    }


    @GetMapping("/dataStorageInf")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DataStorage> getDataStorage(){
        return  dataStorageServices.getDataStorage();
    }

}

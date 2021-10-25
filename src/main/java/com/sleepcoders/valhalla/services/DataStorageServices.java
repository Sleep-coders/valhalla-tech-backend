package com.sleepcoders.valhalla.services;

import com.sleepcoders.valhalla.models.dataStorage.DataStorage;
import com.sleepcoders.valhalla.repository.DataStorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DataStorageServices {

    @Autowired
    DataStorageRepo dataStorageRepo;



    public ResponseEntity<DataStorage> getDataStorage (){
        DataStorage dataStorage = dataStorageRepo.getById(1L);
        return ResponseEntity.ok(dataStorage);
    }
}

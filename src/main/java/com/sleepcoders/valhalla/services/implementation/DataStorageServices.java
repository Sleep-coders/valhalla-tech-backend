package com.sleepcoders.valhalla.services.implementation;

import com.sleepcoders.valhalla.models.dataStorage.DataStorage;
import com.sleepcoders.valhalla.repository.DataStorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DataStorageServices {

    private final DataStorageRepo dataStorageRepo;

    @Autowired
    public DataStorageServices(DataStorageRepo dataStorageRepo) {
        this.dataStorageRepo = dataStorageRepo;
    }

    public ResponseEntity<DataStorage> getDataStorage() {
        DataStorage dataStorage = dataStorageRepo.findById(1L).orElseThrow();
        return ResponseEntity.ok(dataStorage);
    }
}

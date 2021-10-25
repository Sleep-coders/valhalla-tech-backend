package com.sleepcoders.valhalla.repository;

import com.sleepcoders.valhalla.models.dataStorage.DataStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataStorageRepo extends JpaRepository<DataStorage,Long> {

}

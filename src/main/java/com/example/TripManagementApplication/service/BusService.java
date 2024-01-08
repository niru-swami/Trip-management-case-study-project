package com.example.TripManagementApplication.service;

import com.example.TripManagementApplication.model.Bus;

import java.util.List;
import java.util.Optional;

public interface BusService {
    void addBus(Bus bus);
    void deleteBus(String regNumber);
    void editBus(Bus bus);
    Optional<Bus> findByRegNumber(String regNumber);
    List<Bus> getAllBus();
}

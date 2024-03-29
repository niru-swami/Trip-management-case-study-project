package com.example.TripManagementApplication.service;

import com.example.TripManagementApplication.model.Bus;
import com.example.TripManagementApplication.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImplementation implements BusService{

    @Autowired
    BusRepository busRepository;

    @Override
    public void addBus(Bus bus) {
        if(bus.getBusType().equalsIgnoreCase("deluxe")) {
            bus.setBusType("DELUXE");
            busRepository.save(bus);
        } else if (bus.getBusType().equalsIgnoreCase("ordinary")) {
            bus.setBusType("Ordinary");
            busRepository.save(bus);
        } else{
            throw new RuntimeException("Only Deluxe and Ordinary bus type allowed");
        }
    }

    @Override
    public void deleteBus(String regNumber) {
        busRepository.deleteByRegNumber(regNumber);
    }

    @Override
    public void editBus(Bus bus) {
        Optional<Bus> prevBus= busRepository.findBusByRegNumber(bus.getRegNumber());
        if(prevBus.isPresent()) {
            Long busId = prevBus.get().getId();
            busRepository.deleteById(busId);
            bus.setId(busId);
            busRepository.save(bus);
        }
        else{
            throw new RuntimeException("No bus exist with given registration number");
        }
    }

    @Override
    public Optional<Bus> findByRegNumber(String regNumber) {
        return busRepository.findBusByRegNumber(regNumber);
    }

    @Override
    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }
}

package com.example.TripManagementApplication.service;

import com.example.TripManagementApplication.model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {
    void addRoute(Route route);

    Optional<Route> getRoutById(Long id);

    List<Route> getAllRoute();
}

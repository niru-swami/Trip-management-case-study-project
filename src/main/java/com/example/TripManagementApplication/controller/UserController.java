package com.example.TripManagementApplication.controller;

import com.example.TripManagementApplication.model.Bus;
import com.example.TripManagementApplication.model.Route;
import com.example.TripManagementApplication.model.Schedule;
import com.example.TripManagementApplication.payload.response.RouteDetailsResponse;
import com.example.TripManagementApplication.service.BusService;
import com.example.TripManagementApplication.service.RouteService;
import com.example.TripManagementApplication.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  BusService busService;

  @Autowired
  RouteService routeService;

  @Autowired
  ScheduleService scheduleService;

  @GetMapping("/get-all-bus")
  public ResponseEntity<List<Bus>> getAllBus() {
    return ResponseEntity.ok(busService.getAllBus());
  }

  @GetMapping("/get-all-routes")
  public ResponseEntity<List<Route>> getAllRoutes() {
    return ResponseEntity.ok(routeService.getAllRoute());
  }

  @GetMapping("/get-all-schedule")
  public ResponseEntity<List<Schedule>> getAllSchedule() {
    return ResponseEntity.ok(scheduleService.getAllSchedule());
  }

  @GetMapping("/get-schedule-by-route-id/{routeId}")
  public ResponseEntity<List<RouteDetailsResponse>> getScheduleByRouteId(@PathVariable Long routeId) {
    return ResponseEntity.ok(scheduleService.getScheduleByRouteId(routeId));
  }
}

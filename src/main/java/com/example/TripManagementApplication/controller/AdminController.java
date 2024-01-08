package com.example.TripManagementApplication.controller;


import com.example.TripManagementApplication.model.Bus;
import com.example.TripManagementApplication.payload.request.AddBusRequest;
import com.example.TripManagementApplication.payload.request.AddScheduleRequest;
import com.example.TripManagementApplication.payload.response.GenericResponse;
import com.example.TripManagementApplication.service.BusService;
import com.example.TripManagementApplication.service.ScheduleService;
import com.example.TripManagementApplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  BusService busService;

  @Autowired
  ScheduleService scheduleService;

  @Autowired
  UserService userService;

  @PostMapping("/add-bus")
  public ResponseEntity<GenericResponse> addBus(@Valid @RequestBody AddBusRequest addBusRequest) {
    boolean isLoggedIn = userService.isLoggedIn(addBusRequest.getToken());
    if(isLoggedIn) {

      System.out.println("HelloBuddy>>"+addBusRequest);
      busService.addBus(addBusRequest.getBus());
      return ResponseEntity.ok(new GenericResponse("Bus added successfully"));
    }
    else {
      throw new RuntimeException("Invalid credentials");
    }


  }

  @PostMapping("/edit-bus")
  public ResponseEntity<GenericResponse> editBus(@Valid @RequestBody Bus bus) {
    busService.editBus(bus);
    return ResponseEntity.ok(new GenericResponse("Bus edited successfully"));
  }

  @PostMapping("/delete-bus/{regNumber}")
  public ResponseEntity<GenericResponse> deleteBus(@PathVariable String regNumber) {
    busService.deleteBus(regNumber);
    return ResponseEntity.ok(new GenericResponse("Bus deleted successfully"));
  }

  @PostMapping("/add-schedule")
  public ResponseEntity<GenericResponse> addSchedule(
      @RequestBody AddScheduleRequest addScheduleRequest) {
    scheduleService.addSchedule(addScheduleRequest);
    return ResponseEntity.ok(new GenericResponse("Bus deleted successfully"));
  }
}
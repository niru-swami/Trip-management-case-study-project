package com.example.TripManagementApplication.service;

import com.example.TripManagementApplication.model.Schedule;
import com.example.TripManagementApplication.payload.request.AddScheduleRequest;
import com.example.TripManagementApplication.payload.response.RouteDetailsResponse;

import java.util.List;

public interface ScheduleService {
    void addSchedule(AddScheduleRequest addScheduleRequest);

    List<Schedule> getAllSchedule();

    List<RouteDetailsResponse> getScheduleByRouteId(Long routeId);
}

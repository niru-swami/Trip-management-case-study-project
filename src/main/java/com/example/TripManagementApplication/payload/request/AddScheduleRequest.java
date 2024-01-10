package com.example.TripManagementApplication.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;


@Data
public class AddScheduleRequest {
  @NotNull
  private String startTime;

  @NotNull
  private String endTime;

  @NotNull private String busRegNumber;

  @NotNull private Long routeId;
}

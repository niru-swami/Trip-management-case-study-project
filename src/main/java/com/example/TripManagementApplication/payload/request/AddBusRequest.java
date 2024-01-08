package com.example.TripManagementApplication.payload.request;

import com.example.TripManagementApplication.model.Bus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddBusRequest {
    @NotNull private Bus bus;
    @NotNull private String token;
}

package com.babacar.drone.service;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.payload.request.RegisterDroneShippingRequest;
import com.babacar.drone.payload.response.RegisterDroneShippingResponse;

public interface DroneShippingService {
    RegisterDroneShippingResponse registerDroneForShipping(RegisterDroneShippingRequest droneShippingRequest);
}

package com.training.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VehicleManagementService {

	@Autowired
	@Qualifier("jdbcDAO")
	private IVehicleDAO vehicleDAO;	

	public void createNewVehicle(Vehicle vehicle) {		
		vehicleDAO.createVehicle(vehicle);		
	}
	
	public List<Vehicle> getAllVehicles() {
		return vehicleDAO.getAllVehicle();
	}
	
	public Vehicle getVehicle(Vehicle vehicle) {
		return vehicleDAO.getVehicle(vehicle);
	}
	
	public void deleteVehicle(Vehicle vehicle) {
		vehicleDAO.deleteVehicle(vehicle);
	}
	
	public void updateVehicle(Vehicle vehicle) {
		vehicleDAO.updateVehicle(vehicle);
	}
}

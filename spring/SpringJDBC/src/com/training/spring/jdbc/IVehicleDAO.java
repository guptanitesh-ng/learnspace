package com.training.spring.jdbc;

import java.util.List;

public interface IVehicleDAO {

	public void createVehicle(Vehicle Vehicle);
	
	public void updateVehicle(Vehicle vehicle);
	
	public void deleteVehicle(Vehicle vehicle);
	
	public List<Vehicle> getAllVehicle();
	
	public Vehicle getVehicle(Vehicle vehicle);
}

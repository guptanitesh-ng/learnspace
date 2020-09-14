package com.training.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VehicleClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Vehicle vehicle = null;
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"META-INF/springjdbc.xml");
			VehicleManagementService service = context
					.getBean(VehicleManagementService.class);

			vehicle = getVehicle("ZZ990011", "Car", "Blue", 4, 5);
			service.createNewVehicle(vehicle);

			List<Vehicle> vehicleList = service.getAllVehicles();
			System.out.println(vehicleList.size());

			vehicle.setColor("red");
			vehicle.setSeatCount(10);
			service.updateVehicle(vehicle);
			
			vehicle = new Vehicle();
			vehicle.setVehicleNo("ZZ990011");
			vehicle = service.getVehicle(vehicle);
			System.out.println(vehicle.getColor());
			System.out.println(vehicle.getSeatCount());
			
			service.deleteVehicle(vehicle);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private static Vehicle getVehicle(String number, String type, String color,
			int wheelCount, int seatCount) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNo(number);
		vehicle.setType(type);
		vehicle.setColor(color);
		vehicle.setSeatCount(seatCount);
		vehicle.setWheelCount(wheelCount);
		return vehicle;
	}

}

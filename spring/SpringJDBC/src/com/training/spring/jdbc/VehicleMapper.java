package com.training.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VehicleMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNo(rs.getString("VEHICLE_NO"));
		vehicle.setType(rs.getString("TYPE"));
		vehicle.setColor(rs.getString("COLOR"));
		vehicle.setWheelCount(rs.getInt("WHEEL_COUNT"));
		vehicle.setSeatCount(rs.getInt("SEAT_COUNT"));
		return vehicle;

	}	

}

package com.training.spring.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class JDBCVehicleDAO extends NamedParameterJdbcDaoSupport implements
		IVehicleDAO {

	@Override
	public void createVehicle(final Vehicle vehicle) {
		String insertSQL = "INSERT into VEHICLE VALUES (?,?,?,?,?)";
		getJdbcTemplate().update(insertSQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vehicle.getVehicleNo());
				ps.setString(2, vehicle.getType());
				ps.setString(3, vehicle.getColor());
				ps.setInt(4, vehicle.getWheelCount());
				ps.setInt(5, vehicle.getSeatCount());
			}
		});
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		String updateVehicleSQL = "update vehicle set color = :color, seat_Count = :seatCount where vehicle_no = :vehicleNo";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("vehicleNo", vehicle.getVehicleNo());
		paramSource.addValue("color", vehicle.getColor());
		paramSource.addValue("seatCount", vehicle.getSeatCount());		
		getNamedParameterJdbcTemplate().update(updateVehicleSQL, paramSource);
	}

	@Override
	public void deleteVehicle(Vehicle vehicle) {
		getNamedParameterJdbcTemplate().getJdbcOperations().update(
				"Delete from Vehicle where vehicle_No = ?",
				vehicle.getVehicleNo());
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		String getAllVehicleSQL = "SELECT * from VEHICLE";
		return getJdbcTemplate().query(getAllVehicleSQL, new VehicleMapper());
	}

	@Override
	public Vehicle getVehicle(Vehicle vehicle) {
		String getVehicleByVehicleNoSQL = "Select * from VEHICLE where VEHICLE_NO = :VehicleNo";
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(
				vehicle);
		return getNamedParameterJdbcTemplate().queryForObject(
				getVehicleByVehicleNoSQL, paramSource, new VehicleMapper());
	}

}

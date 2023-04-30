package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AloeMapper implements RowMapper<AloeModel> {
	/*match the property names in OrderModel with the column names in the database
	 * 
	 *
	 * */
	
	public AloeModel mapRow(ResultSet resultSet, int i) throws SQLException {
		AloeModel order = new AloeModel(
				resultSet.getLong("ID"),
				resultSet.getString("ORDER_NUMBER"),
				resultSet.getString("PRODUCT_NAME"),
				resultSet.getFloat("PRICE"),
				resultSet.getInt("QTY")
				);
		return order;
	}

}

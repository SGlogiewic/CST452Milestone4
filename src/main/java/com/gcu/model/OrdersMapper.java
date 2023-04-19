package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrdersMapper implements RowMapper<OrderModel> {
	/*match the property names in OrderModel with the column names in the database
	 * 
	 *
	 * */
	
	public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
		OrderModel order = new OrderModel(
				resultSet.getLong("ID"),
				resultSet.getString("ORDER_NUMBER"),
				resultSet.getString("PRODUCT_NAME"),
				resultSet.getFloat("PRICE"),
				resultSet.getInt("QTY")
				);
		return order;
	}

}

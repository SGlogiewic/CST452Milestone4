package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.OrderModel;
import com.gcu.model.OrdersMapper;

/*
 * Three stereotypes are typical for Spring beans. Component, Service and Repository.
 * @Component is a generic stereotype for any Spring-managed component.
 * @Service annotates classes at the service layer.
 * @Repository annotates classes at the persistence layer, which will act as a database repository.
 * */

@Repository
public class OrdersDataService implements OrdersDataAccessInterface<OrderModel> {
	
	//jdbctemplate is a Spring class used to shorten the amount of code needed to interact with a SQL database.
	// dataSource is defined in the aplication.properties file(src/main/resources)
	
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public OrdersDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public OrderModel getById(int id) {
		
		OrderModel result = jdbcTemplate.queryForObject(
				"select * from orders where id = ?",
				new OrdersMapper(),
				new Object[] {id}
				);
		return result;
	}

	@Override
	public List<OrderModel> getOrders() {
		
		return jdbcTemplate.query(
				"select * from orders",
				new OrdersMapper());
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
		return jdbcTemplate.query(
				"select * from orders where PRODUCT_NAME LIKE ?",
				new OrdersMapper(),
				new Object[] {"%" + searchTerm + "%"}
				);
	}

	@Override
	public int addOne(OrderModel newOrder) {
		return jdbcTemplate.update(
				"insert into orders (ORDER_NUMBER, PRODUCT_NAME, PRICE, QTY) values(?,?,?,?)",
				newOrder.getOrderNo(),
				newOrder.getProductName(),
				newOrder.getPrice(),
				newOrder.getQuantity()
				);
	}

	@Override
	public boolean deleteOne(long id) {
		int updateResult = jdbcTemplate.update(
				"delete from orders where id = ?",
				new Object[] {id} );
		return (updateResult > 0);
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		
		int result = jdbcTemplate.update(
				"update orders set ORDER_NUMBER = ?, PRODUCT_NAME = ?, PRICE = ?, QTY = ? where id = ?",
				updateOrder.getOrderNo(),
				updateOrder.getProductName(),
				updateOrder.getPrice(),
				updateOrder.getQuantity(),
				idToUpdate);
		if (result > 0) {
			return updateOrder;
		}
		else {
			return null;
		}
	}

}

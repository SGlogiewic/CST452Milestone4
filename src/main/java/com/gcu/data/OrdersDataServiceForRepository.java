package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.model.OrderEntity;

@Service
public class OrdersDataServiceForRepository implements OrdersDataAccessInterface<OrderEntity>
{
	//ordersrepository is defined as the CrudRepository in Spring
	@Autowired
	private OrdersRepository ordersRepository;
	@SuppressWarnings("unused")
	//datasource is defined in the application.properties file.
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/** Non-Default constructor for constructor injection **/
	public OrdersDataServiceForRepository(OrdersRepository ordersRepository, DataSource dataSource) 
	{
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public OrderEntity getById(int id) {
		return ordersRepository.findById((long) id).orElse(null);
	}
	
	@Override
	public List<OrderEntity> getOrders() {
		List<OrderEntity> orders = (List<OrderEntity>) ordersRepository.findAll();
		
		return orders;
	}
	
	@Override
	public List<OrderEntity> searchOrders(String searchTerm) {
		List<OrderEntity> result = ordersRepository.findByProductNameContainingIgnoreCase(searchTerm);
		return result;
	}
	
	@Override
	public int addOne(OrderEntity newOrder) {
		
		OrderEntity result = ordersRepository.save(newOrder);
		if(result == null) 
		{
			return 0;
		}
		return (int) result.getId();
	}
	
	@Override
	public boolean deleteOne(long id) {
		ordersRepository.deleteById(id);
		return true;
	}
	
	@Override
	public OrderEntity updateOne(long idToUpdate, OrderEntity updateOrder) {
		OrderEntity result = ordersRepository.save(updateOrder);
		return result;
	}
}

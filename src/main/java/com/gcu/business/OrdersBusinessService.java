package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataAccessInterface;
import com.gcu.data.OrdersDataService;
import com.gcu.data.OrdersDataServiceForRepository;
import com.gcu.model.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {
	
	//Uses dependency injection configured in the SpringConfig file
	//To determine which data base (fakeDAO or mySQL, still to be created) will be used.
	@Autowired
	OrdersDataServiceForRepository service;
	
	@Override
	public void test() 
	{
		System.out.println("The test method of the OrdersBusinessService appears to be working if you can see this text.");
	}
	
	@Override
	public void init() 
	{
		System.out.println("Init method of OrdersBusinessService was just called.");
	}
	
	@Override
	public void destroy() 
	{
		System.out.println("Destroy method of OrderBusinessService was just called.");
	}
	
	@Override
	public List<OrderModel> getOrders() 
	{
		//fetch a list of entities
		List<OrderEntity> ordersE = service.getOrders();
		//create an empty list of orders
		List<OrderModel> orders = new ArrayList<OrderModel>();
		//for each entity in list, create a new order and add to orders
		for(OrderEntity entity: ordersE) 
		{
			orders.add(
					//translate from entity to order model
					new OrderModel(
							entity.getId(),
							entity.getOrderNo(),
							entity.getProductName(),
							entity.getPrice(),
							entity.getQuantity()
							)
					);
		}
		return orders;
		
	}
	
	@Override
	public List<OrderModel> searchOrders(String searchTerm) 
	{
		List<OrderEntity> ordersE = service.searchOrders(searchTerm);
		List<OrderModel> orders = new ArrayList<OrderModel>();
		for(OrderEntity entity: ordersE) 
		{
			orders.add(
					new OrderModel(
							entity.getId(),
							entity.getOrderNo(),
							entity.getProductName(),
							entity.getPrice(),
							entity.getQuantity()
							)
					);
		}
		return orders;
	}
	
	@Override
	public int addOne(OrderModel newOrder) 
	{
		OrderEntity entity = new OrderEntity(
				newOrder.getId(),
				newOrder.getOrderNo(),
				newOrder.getProductName(),
				newOrder.getPrice(),
				newOrder.getQuantity()
				);
		return service.addOne(entity);
	}
	
	@Override
	public boolean deleteOne(long id) 
	{
		return service.deleteOne(id);
	}
	
	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) 
	{
		OrderEntity entity = new OrderEntity(
				updateOrder.getId(),
				updateOrder.getOrderNo(),
				updateOrder.getProductName(),
				updateOrder.getPrice(),
				updateOrder.getQuantity()
				);
		OrderEntity result = service.updateOne(idToUpdate, entity);
		
		OrderModel updated = new OrderModel(
				result.getId(),
				result.getOrderNo(),
				result.getProductName(),
				result.getPrice(),
				result.getQuantity()
				);
		return updated;
	}
	
	@Override
	public OrderModel getOne(int id) 
	{
		OrderEntity result = service.getById(id);
		OrderModel order = new OrderModel(
				result.getId(),
				result.getOrderNo(),
				result.getProductName(),
				result.getPrice(),
				result.getQuantity()
				);
		return order;
	}

}

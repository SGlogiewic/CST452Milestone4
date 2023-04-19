package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.gcu.model.OrderModel;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface<OrderModel> {
	
	private List<OrderModel> orders = new ArrayList<OrderModel>();
	
	public OrdersFakeDAO() 
	{
		orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "001", "Sky diving experience", 1500.00f, 1));
		orders.add(new OrderModel(1L, "002", "Run with the bulls in Pamplona", 120.00f, 5));
		orders.add(new OrderModel(2L, "003", "Orbit the Moon with SpaceX", 500000.00f, 2));
		orders.add(new OrderModel(3L, "004", "Shot from a cannon", 420.00f, 1));
		orders.add(new OrderModel(4L, "005", "Zip Line the Grand Canyon", 470.00f, 1));
		orders.add(new OrderModel(5L, "006", "The Whole Enchilada ride in Moab", 220.00f, 3));
		orders.add(new OrderModel(6L, "007", "Wingsuit Jumping lessons in Norway", 900.00f, 4));
		orders.add(new OrderModel(7L, "008", "Backpacking tour to the peak of Kilimanjaro", 300.00f, 4));
		orders.add(new OrderModel(8L, "009", "Sled race the Iditarod", 3500.00f, 2));
		orders.add(new OrderModel(9L, "010", "Scuba dive Jellyfish Lake in Palau", 50.00f, 2));
		orders.add(new OrderModel(10L, "011", "Hike the length of the Pacific Crest Trail", 660.00f, 2));
		orders.add(new OrderModel(11L, "012", "Lemonade by the pool and a book", 2.00f, 1));
	}
	
	//@Override
	public OrderModel getbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Return all orders from the class member variable.
	@Override
	public List<OrderModel> getOrders() 
	{
		return orders;
	}
	
	//Use java streams to filter and select only the orders whose name contains the searchTerm
	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
		//If you like to use streams use this example.
		List<OrderModel> foundItems = orders
				.stream()
				.filter(order -> order.getProductName().toLowerCase()
						.contains(searchTerm.toString().toLowerCase()))
				.collect(Collectors.toList());
		
		/*
		 * This code uses a standard for loop to find the correct order in the list.
		List<OrderModel> foundItems = new ArrayList<OrderModel>();
		for (int i=0; i<orders.size(); i++) {
			if (orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase())) {
				foundItems.add(orders.get(i));
			}
		}*/
		
		//For testing, print a status message to the server console.
		System.out.println("I searched for " + searchTerm + " and found " + foundItems.size() + " items.");
		return foundItems;
	}

	//Add a new order to the orders list
	@Override
	public int addOne(OrderModel newOrder) {
		boolean success = orders.add(newOrder);
		
		//For testing, print a status message to the server console.
		System.out.println("I added one item. Now there are " + orders.size() + "items in the last");
		if (success) 
		{
			return 1;
		}
		return 0;
	}

	//Given the ID number, delete one order from the list
	@Override
	public boolean deleteOne(long id) {
		orders.removeIf(order -> order.getId() == id);
		
		//For testing, print a status message to the server console.
		System.out.println("I removed one item. Now there are " + orders.size() + " items in the list");
		
		return true;
	}

	//Given the id number and a OrderModel, update the order
	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		
		//Find the matching order
		orders.stream().forEach(order -> {
			if (order.getId() == idToUpdate) {order.setOrderNo(updateOrder.getOrderNo());
				order.setPrice(updateOrder.getPrice());
				order.setProductName(updateOrder.getProductName());
				order.setQuantity(updateOrder.getQuantity());
				System.out.println("Updated order " + updateOrder);
			}
		});
		
		//For testing, print a status message to a server console.
		System.out.println("You asked me to update order number " + idToUpdate + ". The updated order is " + updateOrder.toString());
		
		//If no order matches the given idToUpdate, do nothing and return null.
		System.out.println("I tried to find order number " + idToUpdate + " but couldn't find one that matches");
		return null;
		
		/* use a for loop instead of stream if you prefer
		//Find the matching order
		for(int i=0; i < orders.size(); i++) 
		{
			if (orders.get(i).getId() == idToUpdate) 
			{
				orders.get(i).setOrderNo(updateOrder.getOrderNo());
				orders.get(i).setPrice(updateOrder.getPrice());
				orders.get(i).setProductName(updateOrder.getProductName());
				orders.get(i).setQuantity(updateOrder.getQuantity());
				System.out.println("Updated order " + updateOrder);
				return updateOrder;
			}
		}
		*/
	}
	
	@Override
	public OrderModel getById(int id) 
	{
		return orders.stream()
				.filter(order -> order.getId() == id)
				.findFirst()
				.get();
		
		
	}

}

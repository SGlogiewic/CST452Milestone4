package com.gcu.business;

import java.util.List;

import com.gcu.model.AloeModel;

public interface AloeBusinessServiceInterface {
	
	public void test();
	public List<AloeModel> getOrders();
	public List<AloeModel> searchOrders(String searchTerm);
	public int addOne(AloeModel neworder);
	public boolean deleteOne(long l);
	public void init();
	public void destroy();

}

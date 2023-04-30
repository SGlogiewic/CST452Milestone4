package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.gcu.model.AloeEntity;
import com.gcu.model.AloeModel;

public class AloeBusinessService implements AloeBusinessServiceInterface {
	
	
	@Override
	public void test() 
	{
		System.out.println("The test method of the AloeBusinessService appears to be working if you can see this text.");
	}
	
	@Override
	public void init() 
	{
		System.out.println("Init method of AloeBusinessService was just called.");
	}
	
	@Override
	public void destroy() 
	{
		System.out.println("Destroy method of AloeBusinessService was just called.");
	}

	@Override
	public List<AloeModel> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AloeModel> searchOrders(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOne(AloeModel neworder) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteOne(long l) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}

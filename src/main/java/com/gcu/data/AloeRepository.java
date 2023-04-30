package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.model.AloeEntity;

public interface AloeRepository extends CrudRepository<AloeEntity, Long>{
	List<AloeEntity> findByProductNameContainingIgnoreCase(String searchTerm);

}

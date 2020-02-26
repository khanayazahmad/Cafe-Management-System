package com.cmpe202.starbucks.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.cmpe202.starbucks.model.Menu;

public interface IMenuRepository extends CrudRepository<Menu, Long>{
	Menu findById(long id);
	ArrayList<Menu> findAll();
	List<Menu> findAllById(List<Long> id);
}

package me.rashmi.billingsystem.dish;

import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long>{
	
	Dish findByName(String dishName);
	
	void deleteDishByName(String dishName);
}

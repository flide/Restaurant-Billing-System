package me.rashmi.billingsystem.dish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {
	
	@Autowired
	private DishRepository dishRepository;
	
	public List<Dish> getAllDishes() {
		List<Dish> dishes = new ArrayList<>();
		dishRepository.findAll().forEach(dishes::add);
		return dishes;
	}

	public void addDish(Dish dish) {
		dishRepository.save(dish);
	}

	public void updateDish(Dish dish) {
		dishRepository.save(dish);
	}

	public void deleteDishById(long id) {
		dishRepository.delete(id);
	}

	public void deleteDish(Dish dish) {
		dishRepository.delete(dish);
	}
	
	public void deleteDishByName(String name) {
		dishRepository.deleteDishByName(name);
	}

	public Dish searchForDishByName(String name) {
		return dishRepository.findByName(name);
	}
	
}

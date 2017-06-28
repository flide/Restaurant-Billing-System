package me.rashmi.billingsystem.dish;

import java.util.List;

import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/dishes")
@RestController
public class DishController {
	
	@Autowired
	private DishService dishService;
	
	@ApiMethod(description="Retrive the list of all dishes on the Menu",
			summary="Get all dishes")
	@RequestMapping(method=RequestMethod.GET)
	public List<Dish> getAllDishes() {
		return dishService.getAllDishes();
	}
	
	@ApiMethod(description="Retrive the details of single dish on the Menu based on name")
	@RequestMapping(method=RequestMethod.GET, value="/{name}")
	public Dish getDishByName(@PathVariable String name) {
		return dishService.searchForDishByName(name);
	}
	
	@ApiMethod(description="Add a new dish to the Menu")
	@RequestMapping(method=RequestMethod.POST)
	public void addDish(@RequestBody Dish dish){
		dishService.addDish(dish);
	}
	
	@ApiMethod(description="Edit details of an existing dish on the Menu")
	@RequestMapping(method=RequestMethod.PUT)
	public void updateDish(@RequestBody Dish dish){
		dishService.updateDish(dish);
	}
	
	@ApiMethod(description="Delete dish from the Menu based on the name of the dish")
	@RequestMapping(method=RequestMethod.DELETE, value="/{name}")
	public void deleteDish(@PathVariable String name){
		dishService.deleteDishByName(name);
	}
	
	@ApiMethod(description="Delete dish from the Menu")
	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteDish(@RequestBody Dish dish){
		dishService.deleteDish(dish);
	}

}

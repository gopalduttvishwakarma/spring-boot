package com.restapidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapidemo.entities.Car;
import com.restapidemo.repositories.CarRepo;

import jakarta.transaction.Transactional;

@RestController
public class CarController {
	
	@Autowired
	private CarRepo carRepo;

	@GetMapping("/totalCarsByModel")
	public int getTotalCarsByModel(@RequestParam("model") String model) {
		System.out.println("model="+model);
		return carRepo.getTotalCarsByModel(model);
	}
	
	@PostMapping("/addCar")
	@Transactional
	public String addNewCar(@RequestBody Car car) {
		return carRepo.addCar(car.getModel(), car.getYear());
	}
	
	@GetMapping("/getAllCars")
	@Transactional
	public List<Car> getAllCars() {
		return carRepo.findAllCars();
	}
	
	@GetMapping("/getCarsByYear")
	@Transactional
	public List<Car> getAllCarsByYear(@RequestParam("year") Integer year) {
		return carRepo.findAllCarsAfterYear(year);
	}
}
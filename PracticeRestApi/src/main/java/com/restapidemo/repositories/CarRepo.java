package com.restapidemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restapidemo.entities.Car;

import jakarta.transaction.Transactional;

@Repository
public interface CarRepo extends JpaRepository<Car, Long>{
	
	@Procedure(procedureName = "GET_TOTAL_CARS_BY_MODEL")
	int getTotalCarsByModel(String model);
	
	@Transactional
	@Procedure(procedureName = "ADD_CAR")
	String addCar(String model, int year);
	
	@Procedure(procedureName = "ALL_CARS")
	List<Car> findAllCars();
	
//	@Procedure(name = "Car.getCarAfterYear")
	@Procedure(procedureName = "FIND_CARS_AFTER_YEAR")
	List<Car> findAllCarsAfterYear(@Param("year_in") Integer year_in);
}

package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Car;

public interface CarRepo extends CrudRepository<Car,String>{

}

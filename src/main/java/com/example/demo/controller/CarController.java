package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Car;
import com.example.demo.repo.CarRepo;
import com.examples.demo.util.Output;

@RestController
public class CarController {

	@Autowired
	CarRepo repo;

	@RequestMapping("home")
	public ModelAndView homePage() {
		Output.print("in home");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("addCar")
	public ModelAndView add(Car car) {
		Output.print("in addCar");
		repo.save(car);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	/*
	 * @RequestMapping("getCar") public ModelAndView show(@RequestParam String vin)
	 * { Output.print("in showCar"); Car car=repo.findById(vin). orElse(null);
	 * ModelAndView mv = new ModelAndView(); mv.addObject(car);
	 * mv.setViewName("showcar"); return mv; }
	 */

	@RequestMapping("car/{vin}")
	@ResponseBody
	public Car show(@PathVariable ("vin")String vin) {
		Output.print("in show");
		 return repo.findById(vin). orElse(null);
	}

	
	
	@PostMapping("car")
	public Car addCar(@RequestBody Car car) {
		repo.save(car);
		 return car;
	}
}

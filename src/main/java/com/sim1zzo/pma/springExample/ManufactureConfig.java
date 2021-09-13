package com.sim1zzo.pma.springExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ManufactureConfig {

	
	@Bean
	public Car newCar() {
		var e = new Engine();
		var d = new Door();
		var t = new Tire();
		return new Car(e, d, t);
	}
}

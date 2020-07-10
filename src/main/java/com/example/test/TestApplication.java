package com.example.test;

import com.example.test.model.*;
import com.example.test.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository carRepository,
						   GenderRepository genderRepository,
						   StatusCarRepository statusCarRepository,
						   UserRepository userRepository,
						   OrdersRepository ordersRepository) {
		return args -> {
			Stream.of("Ready","Not Ready","To Fix").forEach(status -> {
				StatusCar statusCar = new StatusCar();
				statusCar.setStatus(status);
				statusCarRepository.save(statusCar);
			});

			Stream.of("male","female").forEach(gen -> {
				Gender gender = new Gender();
				gender.setGender(gen);
				genderRepository.save(gender);
			});

			Car car1 = new Car();
			car1.setCarId("AB1234");
			car1.setCarName("Ford");
			car1.setStatusCar(statusCarRepository.findById(1));
			carRepository.save(car1);

			Car car2 = new Car();
			car2.setCarId("BC5555");
			car2.setCarName("Toyota");
			car2.setStatusCar(statusCarRepository.findById(2));
			carRepository.save(car2);

			Car car3 = new Car();
			car3.setCarId("AN4234");
			car3.setCarName("Honda");
			car3.setStatusCar(statusCarRepository.findById(3));
			carRepository.save(car3);

			User user1 = new User();
			user1.setName("Prayut Chan");
			user1.setAge(66);
			user1.setPassport("1234567891011");
			user1.setGender(genderRepository.findById(1));
			userRepository.save(user1);

			User user2 = new User();
			user2.setName("Prawit Wong");
			user2.setAge(74);
			user2.setPassport("1234567891099");
			user2.setGender(genderRepository.findById(1));
			userRepository.save(user2);

			User user3 = new User();
			user3.setName("Pareena Krai");
			user3.setAge(44);
			user3.setPassport("1234522291099");
			user3.setGender(genderRepository.findById(2));
			userRepository.save(user3);

			Orders order1 = new Orders();
			order1.setCar(carRepository.findById(2));
			order1.setUsers(userRepository.findById(1));
			order1.setTimestart(new Date(60,1,1));
			
			ordersRepository.save(order1);
		};
	}
}

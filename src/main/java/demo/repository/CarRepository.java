package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}

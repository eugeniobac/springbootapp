package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.Car;
import demo.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Override
    public void add(Car car) {
	repository.save(car);
    }

    @Override
    public void update(Car car) {
	repository.save(car);
    }

    @Override
    public List<Car> findAll() {
	return repository.findAll();
    }

    @Override
    public Car getById(Integer id) {
	return repository.findOne(id);
    }

    @Override
    public void remove(Integer id) {
	repository.delete(id);
    }

}

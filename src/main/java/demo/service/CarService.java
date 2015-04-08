package demo.service;

import java.util.List;

import demo.model.Car;

public interface CarService {
    public void add(Car p);

    public void update(Car p);

    public List<Car> findAll();

    public Car getById(Integer id);

    public void remove(Integer id);
}

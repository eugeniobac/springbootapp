package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import demo.model.Car;
import demo.service.CarService;

@Controller
public class CarController {

    @Autowired
    private CarService service;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
	System.out.println("Hello World!!!");
	model.addAttribute("name", name);
	return "helloworld";
    }

    @RequestMapping(value = "/car/list", method = RequestMethod.GET)
    public String list(Model model) {
	model.addAttribute("car", new Car());
	model.addAttribute("cars", service.findAll());

	return "car";
    }

    @RequestMapping("/car/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
	model.addAttribute("car", this.service.getById(id));
	model.addAttribute("cars", this.service.findAll());
	return "car";
    }

    @RequestMapping("/car/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
	service.remove(id);

	return "redirect:/car/list";
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("car") Car car) {
	service.add(car);
	return "redirect:/car/list";
    }

}

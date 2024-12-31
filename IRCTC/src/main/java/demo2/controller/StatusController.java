package demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo2.entity.Status;
import demo2.service.StatusService;


@RestController
public class StatusController {
	
	@Autowired
	StatusService service;
	
	@GetMapping("/getStatus/{id}")
	public Status getStatus(@PathVariable("id") int id) 
	{
		return service.getStatus(id);
	}
	@PostMapping("/addStatus")
	public String addStatus(@RequestBody Status status) 
	{
		service.addStatus(status);
		return "added";
	}

}

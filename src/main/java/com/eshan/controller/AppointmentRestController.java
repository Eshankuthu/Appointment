package com.eshan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshan.model.Appointment;
import com.eshan.service.AppointmentService;

@RestController
public class AppointmentRestController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping(value="/appointment")
    public  ResponseEntity<List<Appointment>> findAppointBySearch(String searchstr){
		List<Appointment> appointment;
        if(searchstr!=(null) && searchstr.trim().length()>0){
        	appointment= appointmentService.getBySearch(searchstr);
        }
        appointment= appointmentService.getAllAppointment();
        
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

	
	@PostMapping(value="/addAppointment")
	public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment){
		appointmentService.saveAppointment(appointment);
		return new ResponseEntity<>(appointment, HttpStatus.CREATED);
	
	}
}

package com.eshan.controller;

import java.util.ArrayList;
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

	@GetMapping("/appointment")
	public List<Appointment> getAppointments(String str) {
		if (str != (null) && str.trim().length() > 0) {
			return appointmentService.getBySearch(str);
		}
		return appointmentService.getAllAppointment();
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
		appointmentService.saveAppointment(appointment);
		return new ResponseEntity<>(appointment, HttpStatus.CREATED);

	}
}

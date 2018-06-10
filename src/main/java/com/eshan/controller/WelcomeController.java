package com.eshan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshan.model.Appointment;
import com.eshan.service.AppointmentService;

@Controller
public class WelcomeController {

	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@PostMapping("/addAppointment")
	public String addAppointment(Appointment appointment, Model model) {
		System.out.println("Appointment Page Requested");
		System.out.println(appointment);
		appointmentService.saveAppointment(appointment);
		   return "redirect:/";
	}
}

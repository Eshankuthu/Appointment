package com.eshan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshan.model.Appointment;
import com.eshan.repository.AppointmentRepo;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepo appointmentrepo;

	public List<Appointment> getAllAppointment() {
		return appointmentrepo.findAll();
	}

	public void saveAppointment(Appointment appointment) {
		appointmentrepo.save(appointment);
	}
	
	public List<Appointment> getBySearch(String searchstr){
		return appointmentrepo.findByDescription(searchstr);
	}
}

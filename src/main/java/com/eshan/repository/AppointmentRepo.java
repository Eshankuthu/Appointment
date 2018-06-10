package com.eshan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshan.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
	
	public List<Appointment> findByDescription(String searchstr);

}

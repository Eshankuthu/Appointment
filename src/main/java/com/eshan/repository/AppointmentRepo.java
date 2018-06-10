package com.eshan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eshan.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
	
	/*public List<Appointment> findByDescription(String searchstr);*/
	
	   @Query("SELECT a FROM Appointment a WHERE a.description like ?1")
	    public List<Appointment> searchByDescription(String searchstr);

}

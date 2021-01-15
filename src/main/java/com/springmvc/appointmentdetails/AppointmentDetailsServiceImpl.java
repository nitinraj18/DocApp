package com.springmvc.appointmentdetails;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.model.AppointmentDetails;

@Service
public class AppointmentDetailsServiceImpl implements AppointmentDetailsService{

	@Autowired
	private AppointmentDetailsDAO appointmentDetailsDAO; 
	
	@Transactional
	@Override
	public void saveAppointmentDetails(AppointmentDetails appointmentDetails) {
		appointmentDetailsDAO.saveAppointmentDetails(appointmentDetails);
		
	}

	@Transactional
	@Override
	public List<AppointmentDetails> getAllData() {
		// TODO Auto-generated method stub
		return appointmentDetailsDAO.getAllData();
	}

}

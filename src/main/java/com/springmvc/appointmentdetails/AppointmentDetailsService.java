package com.springmvc.appointmentdetails;

import java.util.List;

import com.springmvc.model.AppointmentDetails;

public interface AppointmentDetailsService {
	
	public void saveAppointmentDetails(AppointmentDetails appointmentDetails);
	
	public List<AppointmentDetails> getAllData();

}

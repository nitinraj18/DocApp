package com.springmvc.appointmentdetails;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.model.AppointmentDetails;

@Repository
public class AppointmentDetailsDAOImpl implements AppointmentDetailsDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveAppointmentDetails(AppointmentDetails appointmentDetails) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(appointmentDetails);
	System.out.println("Data Saved");
	}

	@Override
	public List<AppointmentDetails> getAllData() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		TypedQuery<AppointmentDetails> query= session.createQuery("from AppointmentDetails");
		List<AppointmentDetails> list= query.getResultList();
		return list;
	}

}

package com.springmvc.controller;


import java.sql.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.appointmentdetails.AppointmentDetailsService;
import com.springmvc.config.UploadFileFunctionality;
import com.springmvc.email.EmailDetails;
import com.springmvc.email.SendEmailInterface;
import com.springmvc.fileuploadfunctionality.FileUploadFunctionality;
import com.springmvc.model.AppointmentDetails;


@Controller
public class PatientController {
	
	@Autowired
	private UploadFileFunctionality uploadProp;
	
	@Autowired
	private FileUploadFunctionality multipleFileFunCall;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	private AppointmentDetailsService appointmentDetailsService;
	
	@Autowired
	private SendEmailInterface emailFun;
	
	private final String HOME_PAGE="/HomePage";
	private final String DATA_SAVED="/DataSaved";
	private final String DISPLAYDATA="/Display"; 
	
	@RequestMapping("/")
	public ModelAndView HomePageView(HttpSession httpSession)
	{
	
		System.out.println("Step 3 : controller called ");
		ModelAndView mv=new ModelAndView(HOME_PAGE);
		System.out.println("Step 4 : ");
		System.out.println("Called header");
		
		return mv;
	}
	
	@PostMapping("savepatient")
	public ModelAndView saveData(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("dob") Date dob,
			@RequestParam("bloodGroup") String bloodGroup,
			@RequestParam("address") String address,
			@RequestParam("mobileNumber") long mobileNumber,
			@RequestParam("emailId") String emailId,
			@RequestParam("dateOfAppointment") Date dateOfAppointment,
			@RequestParam(required = false ,name="reportPath") CommonsMultipartFile[] reportPath, 
			HttpSession httpSession)
	{
		System.out.println("patient Details Saved" );
		
		String rootpath=System.getProperty("catalina.home");
		String relativepath=uploadProp.pathLocation().getProperty("RELATIVELOCATION");
		String basepath=uploadProp.pathLocation().getProperty("PATIENTREPORT");
		
		
		List<String> filenameList=multipleFileFunCall.multipleFileUpload(rootpath, relativepath, basepath, reportPath);
		   StringBuilder filename= new StringBuilder();
		     for(int i=0;i<filenameList.size();i++) 
		     {
		    	 if(i>0) 
			    	{
			    		filename=filename.append(',');	
			    	}
		    	filename=filename.append(filenameList.get(i));
	          }
		
		     AppointmentDetails ad= new AppointmentDetails();
		     ad.setName(name);
		     ad.setAge(age);
		     ad.setDob(dob);
		     ad.setBloodGroup(bloodGroup);
		     ad.setAddress(address);
		     ad.setMobileNumber(mobileNumber);
		     ad.setEmailId(emailId);
		     ad.setDateOfAppointment(dateOfAppointment);
		     ad.setPathName(filename.toString());
		     
		     appointmentDetailsService.saveAppointmentDetails(ad);
		
		ModelAndView mv = new ModelAndView(DATA_SAVED); 
		return mv;
	}
	
	
	@GetMapping("viewdata")
	public ModelAndView viewData(HttpSession httpSession) 
		{
		
		List<AppointmentDetails> appointmentList=appointmentDetailsService.getAllData();
		ModelAndView mv=new ModelAndView(DISPLAYDATA);
		request.setAttribute("patientList", appointmentList);
		return mv;
        }

	@RequestMapping("/HomePage")
	public ModelAndView HomePageLoad(HttpSession httpSession)
	{
	
		System.out.println("Step 3 : controller called ");
		ModelAndView mv=new ModelAndView(HOME_PAGE);
		System.out.println("Step 4 : ");
		System.out.println("Called header");
		return mv;
	}
	
	@GetMapping("sendMail")
	public String sendMail(@RequestParam String toSend ,HttpSession httpSession) 
	{
		System.out.println("Send mail  : " +toSend);
		//System.out.println("Doctor Name"+doctorAvailable);
		EmailDetails emailDetails= new EmailDetails();
		emailDetails.setToList(toSend);
		emailDetails.setEmailSubject("Appointment Notification");
		emailDetails.setEmailBody("This doctor will attend you . . . . ");
		
		try {
     	   String getstr=emailFun.sendMail(emailDetails);
			   System.out.println("Response from mail : "+getstr);
			   
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (MessagingException e) {
			// TODO: handle exception
		}
		
		return "redirect:viewdata";
	} 

	
	
	
	
	
}

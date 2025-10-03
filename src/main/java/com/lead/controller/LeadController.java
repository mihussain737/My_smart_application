package com.lead.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lead.dto.LeadDto;
import com.lead.entity.Lead;
import com.lead.service.EmailService;
import com.lead.service.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;

	//http://localhost:8080/viewLeadForm
	@RequestMapping("/viewLeadForm")
	public String viewLeadForm() {
		return "create_lead";
	}
	/*
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead,Model model) {
		leadService.saveLead(lead);
		model.addAttribute("msg","Lead is saved successfully!!");
		return "create_lead";
	}*/
	
	/*
	@RequestMapping("/saveLead")
	public String secondSaveLead(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("mobile") Long mobile,
	Model model) {
		Lead lead =new Lead(firstName,lastName,email,mobile);
		leadService.saveLead(lead);
		model.addAttribute("msg","Lead is saved successfully!!");
		return "create_lead";
	}*/
	
	/*
	@RequestMapping("/saveLead")
	public String thirdSaveLead(HttpServletRequest request, Model model) {
		Lead lead =new Lead();
		lead.setFirstName(request.getParameter("firstName"));
		lead.setLastName(request.getParameter("lastName"));
		lead.setEmail(request.getParameter("email"));
		lead.setMobile(Long.parseLong(request.getParameter("mobile")));
		leadService.saveLead(lead);
		model.addAttribute("msg","Lead is saved successfully!!");
		return "create_lead";
	} */
	
	@RequestMapping("/saveLead")
	public String fourthSaveLead(LeadDto leadDto, Model model) {
		Lead lead =new Lead(leadDto.getFirstName(),leadDto.getLastName(),leadDto.getEmail(),leadDto.getMobile());
		leadService.saveLead(lead);
		model.addAttribute("msg","Lead is saved successfully!!");
		return "create_lead";
	}
	@RequestMapping("/list_leads")
	public String getAllLeads(Model model) {
		List<LeadDto>allLeads=leadService.getAllLeads();
		model.addAttribute("leads", allLeads);
		return"list_leads";
	}
	
	@RequestMapping("/update")
	public String viewUpdateForm(@RequestParam("id") Long id,Model model) {
		LeadDto lead = leadService.getLeadById(id);
		model.addAttribute("lead", lead);
		return"create_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateLeadById(@ModelAttribute LeadDto leadDto,
			@RequestParam("id") Long id,Model model,HttpServletRequest request) {
		leadService.updateLeadById(id, leadDto);
		System.out.println(request.getParameter("id"));
		List<LeadDto>allLeads=leadService.getAllLeads();
		model.addAttribute("leads", allLeads);
		return"list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteLeadById(HttpServletRequest request,Model model,@RequestParam("id")Long id) {
		leadService.deleteLeadById(Long.parseLong(request.getParameter("id")));
		System.out.println("id ::"+id);
		List<LeadDto>allLeads=leadService.getAllLeads();
		model.addAttribute("leads", allLeads);
		return"list_leads";
	}
	
	@RequestMapping("/sendMail")
	public String sendMailById(@RequestParam("id") Long id,@RequestParam("emailMessage") String body
			,Model model) {
		LeadDto lead = leadService.getLeadById(id);
		String sub="testSubject";
		emailService.sendSimpleMail(lead.getEmail(), sub, body);
		model.addAttribute("sentLeadId", id); 
		model.addAttribute("sentMsg","Email Sent Successfully!!");
		List<LeadDto>allLeads=leadService.getAllLeads();
		model.addAttribute("leads", allLeads);
		return "list_leads";
	}
}

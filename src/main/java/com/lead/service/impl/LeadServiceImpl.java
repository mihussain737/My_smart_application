package com.lead.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lead.dto.LeadDto;
import com.lead.entity.Lead;
import com.lead.repository.LeadRepository;
import com.lead.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepository;

	@Override
	public void saveLead(Lead lead) {
		leadRepository.save(lead);
	}
	@Override
	public List<LeadDto> getAllLeads() {
		List<Lead> allLeads = leadRepository.findAll();
		List<LeadDto> allLeadsDtos = allLeads.stream()
				.map(i -> new LeadDto(i.getId(), i.getFirstName(), i.getLastName(), i.getEmail(), i.getMobile()))
				.toList();
		return allLeadsDtos;
	}
	@Override
	public LeadDto getLeadById(Long id) {
		Lead lead = leadRepository.findById(id).get();
		LeadDto leadDto=new LeadDto(lead.getId(),lead.getFirstName(),lead.getLastName(),lead.getEmail(),lead.getMobile());
		return leadDto;
	}
	@Override
	public void updateLeadById(Long id,LeadDto leadDto) {
		Lead lead = leadRepository.findById(id).get();
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		leadRepository.save(lead);
	}
	@Override
	public void deleteLeadById(Long id) {
		leadRepository.deleteById(id);
	}
}

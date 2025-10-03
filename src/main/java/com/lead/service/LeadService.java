package com.lead.service;

import java.util.List;

import com.lead.dto.LeadDto;
import com.lead.entity.Lead;

public interface LeadService {
	public void saveLead(Lead lead);
	public List<LeadDto> getAllLeads();
	public LeadDto getLeadById(Long id);
	public void updateLeadById(Long id,LeadDto leadDto);
	public void deleteLeadById(Long id);
}

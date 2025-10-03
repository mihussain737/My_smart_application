package com.lead.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class LeadDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Long mobile;
}

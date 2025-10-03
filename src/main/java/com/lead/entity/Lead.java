package com.lead.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name="leads")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Lead(String firstName, String lastName, String email, Long mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}
	private String firstName;
	private String lastName;
	private String email;
	private Long mobile;
}

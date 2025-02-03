package org.jsp.CDA.entities;

import org.jsp.CDA.util.Role;
import org.jsp.CDA.util.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(unique = true,nullable = false)
	private String username;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(unique = true,nullable = false,length = 10)
	private long phone;
	@Column(nullable = false)
	private String password;
	@Column(length = 6)
	private int otp;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	@Enumerated(EnumType.STRING)
	private Status status;
	

}

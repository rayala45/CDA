package org.jsp.CDA.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	@Id
	private int id;
	private String photo;
	private String year;
	
	@ManyToOne
	private Department department;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="id")
	private User user;

}

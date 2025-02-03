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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Adminstrator {
	@Id
	private int id;
	private String photo;
	
	@ManyToOne
	private Department department;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="id")
	private User user;

}

package org.jsp.CDA.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvalidFacultyIdException  extends RuntimeException{

	private String message;
	@Override
	public String getMessage() {
	return this.message;
	}
}

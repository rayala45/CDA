package org.jsp.CDA.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvalidDepartmentNameException extends RuntimeException {
	private String message;
	@Override
	public String getMessage() {
	return this.message;
	}
}

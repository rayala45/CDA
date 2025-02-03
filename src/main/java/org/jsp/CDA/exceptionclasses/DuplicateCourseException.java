package org.jsp.CDA.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DuplicateCourseException extends RuntimeException{
	private String message;
	@Override
	public String getMessage() {
		return this.message;
	}

}

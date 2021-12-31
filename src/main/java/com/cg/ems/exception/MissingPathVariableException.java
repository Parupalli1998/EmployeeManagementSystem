package com.cg.ems.exception;

import org.springframework.core.MethodParameter;

public class MissingPathVariableException {
	public MissingPathVariableException(String variableName,
            MethodParameter parameter,
            boolean missingAfterConversion)
	{
		
	}
}

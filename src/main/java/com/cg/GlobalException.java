package com.cg;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.ems.error.ErrorInfo;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.exception.LoginException;



public class GlobalException {
	@ExceptionHandler(EmployeeException.class)
	public @ResponseBody ErrorInfo getEmployeeExeptionHandler(Exception e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(),req.getRequestURI());
	}

	@ExceptionHandler(LoginException.class)
	public @ResponseBody ErrorInfo getLoginExceptionHandler(Exception e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(),req.getRequestURI());

	}
}

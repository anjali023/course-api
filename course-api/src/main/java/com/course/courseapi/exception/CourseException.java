package com.course.courseapi.exception;

import com.course.courseapi.core.BaseException;

public class CourseException extends BaseException {

	public CourseException(String errorCode, String errorMessage, String errorDesc, String successStatus) {
		super(errorCode, errorMessage, errorDesc, successStatus);
		
		// TODO Auto-generated constructor stub
	}

}

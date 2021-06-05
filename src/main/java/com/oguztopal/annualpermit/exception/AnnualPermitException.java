package com.oguztopal.annualpermit.exception;

import java.io.Serializable;

public class AnnualPermitException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -1509207678648896828L;

	public AnnualPermitException(String message, Throwable cause) {
		super(message);
		super.initCause(cause);
	}

	public AnnualPermitException(String message) {
		super(message);
	}

}

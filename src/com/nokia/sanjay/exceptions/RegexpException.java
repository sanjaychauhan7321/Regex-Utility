package com.nokia.sanjay.exceptions;

/**
 * 
 * @author <a href=
 *         "https://www.youracclaim.com/badges/1cacfc10-a704-44ed-94b4-1cd7abbfd168/public_url"
 *         style="color:red; font-size:16; "><em>Sanjay Chauhan</em></a>
 */

public class RegexpException extends Throwable {

	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorMessage;

	public RegexpException(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}

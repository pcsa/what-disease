package br.com.imd.whatDisease.util;

public class CustomException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException() {
		super();
	}
	
	public CustomException(String msg, Throwable thr) {
		super(msg,thr);
	}
	
	public CustomException(String msg) {
		super(msg);
	}
	
	public CustomException(Throwable thr) {
		super(thr);
	}
}

package br.com.imd.whatDisease.util;

public class CustomExceptions extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomExceptions() {
		super();
	}
	
	public CustomExceptions(String msg, Throwable thr) {
		super(msg,thr);
	}
	
	public CustomExceptions(String msg) {
		super(msg);
	}
	
	public CustomExceptions(Throwable thr) {
		super(thr);
	}
}

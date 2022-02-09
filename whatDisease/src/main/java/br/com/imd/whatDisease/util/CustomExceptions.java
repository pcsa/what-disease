package br.com.imd.whatDisease.util;

public class CustomExceptions extends Exception {
	
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

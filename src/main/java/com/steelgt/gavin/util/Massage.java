package com.steelgt.gavin.util;

public class Massage {
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	// 0表示成功;-1表示失败
	int status;
	// 向前端返回的内容
	String massage;

	public Massage() {
		super();
	}

	public Massage(int status, String massage) {
		super();
		this.status = status;
		this.massage = massage;
	}
}

package com.payment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment{
	
	private String id;
	private String method;
	private String amount;
	private String date;
	private String cardNo;

	
	public Payment() {
		super();
	}


	public Payment(String id, String method, String amount, String date, String cardNo) {
		super();
		this.id = id;
		this.method = method;
		this.amount = amount;
		this.date = date;
		this.cardNo = cardNo;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getCardNo() {
		return cardNo;
	}


	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}


	@Override
	public String toString() {
		return "Payment [id=" + id + ", method=" + method + ", amount=" + amount + ", date=" + date
				+ ", cardNo=" + cardNo + "]";
	}
	
	

}

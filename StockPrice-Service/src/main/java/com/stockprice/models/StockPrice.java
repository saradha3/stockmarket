package com.stockprice.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stockprice")
public class StockPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockPriceId;
	
	private String companyCode;
	
	private double stockPrice;
	
	private Date date;
	
	private String time;

	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockPrice(int stockPriceId, String companyCode, double stockPrice, Date date, String time) {
		super();
		this.stockPriceId = stockPriceId;
		this.companyCode = companyCode;
		this.stockPrice = stockPrice;
		this.date = date;
		this.time = time;
	}

	public int getStockPriceId() {
		return stockPriceId;
	}

	public void setStockPriceId(int stockPriceId) {
		this.stockPriceId = stockPriceId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}

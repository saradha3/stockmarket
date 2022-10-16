package com.stock.payloads;

import java.util.List;

import com.stock.models.StockPrice;

public class CompanyDto {
	
	private int companyId;
	private String companyCode;
	private String companyName;
	private String companyCEO;
	private int companyTurnover;
	private String companyWebsite;
	private String stockExchange;
	private List<StockPrice> stockPrice;
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String comapanyCode) {
		this.companyCode = comapanyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public double getCompanyTurnover() {
		return companyTurnover;
	}
	public void setCompanyTurnover(int companyTurnover) {
		this.companyTurnover = companyTurnover;
	}
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	
	
	public List<StockPrice> getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(List<StockPrice> stockPrice) {
		this.stockPrice = stockPrice;
	}
	@Override
	public String toString() {
		return "CompanyDto [companyId=" + companyId + ", companyCode=" + companyCode + ", companyName=" + companyName
				+ ", companyCEO=" + companyCEO + ", companyTurnover=" + companyTurnover + ", companyWebsite="
				+ companyWebsite + ", stockExchange=" + stockExchange + ", stockPrice=" + stockPrice + "]";
	}
	
	
	
	

}

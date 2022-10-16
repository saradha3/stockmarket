package com.stock.models;

import java.util.List;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "company")
public class Company {
	
	@Transient
    public static final String SEQUENCE_NAME = "company_sequence";
	
	@Id
	private int companyId;
	
	
	@NotNull(message = "comapanyCode cannot be null")
	@NotEmpty(message = "comapanyCode cannot be empty")
	private String companyCode;
	
	@NotNull(message = "companyName cannot be null")
	@NotEmpty(message = "companyName cannot be empty")
	private String companyName;
	
	@NotNull(message = "companyCEO cannot be null")
	@NotEmpty(message = "companyCEO cannot be empty")
	private String companyCEO;
	
	@Min(value = 100000000, message = "companyTurnover must be greater than or equal to 10Cr")
	@NotNull(message = "companyTurnover cannot be null")
	private int companyTurnover;
	
	@NotNull(message = "companyWebsite cannot be null")
	@NotEmpty(message = "companyWebsite cannot be empty")
	private String companyWebsite;
	
	@NotNull(message = "stockExchange cannot be null")
	@NotEmpty(message = "stockExchange cannot be empty")
	private String stockExchange;
	
	private List<StockPrice> stockPrice;
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Company(int companyId, String comapanyCode,String companyName,String companyCEO,int companyTurnover,
			String companyWebsite,String stockExchange,List<StockPrice> stockPrice) {
		super();
		this.companyId = companyId;
		this.companyCode = comapanyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTurnover = companyTurnover;
		this.companyWebsite = companyWebsite;
		this.stockExchange = stockExchange;
		this.stockPrice = stockPrice;
	}



	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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
	
	
	

}

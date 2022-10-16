package com.stockprice.services;

import java.util.Date;
import java.util.List;

import com.stockprice.payloads.StockPriceDto;

public interface StockPriceService {
	
	public StockPriceDto add(StockPriceDto stockPriceDto, String companyCode);
	
	public StockPriceDto update(StockPriceDto stockPriceDto, int id);
	
	public List<StockPriceDto> updateByCompanyCode(StockPriceDto stockPriceDto, String companyCode);
	
	public void deleteStockPriceById(int id);
	
	public void deleteStockPriceByCompany(String companyCode);
	
	public StockPriceDto getLatestStockPriceOfCompany(String companycode);
	
	public List<StockPriceDto> getStockPriceBetween(String companycode, Date start, Date end);
	
	public StockPriceDto getMaxStockPriceBetween(String companycode, Date start, Date end);
	
	public StockPriceDto getMinStockPriceBetween(String companycode, Date start, Date end);
	
}

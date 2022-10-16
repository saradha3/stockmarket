package com.stockprice.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stockprice.models.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Integer> {

	public List<StockPrice> findAllByCompanyCode(String companyCode);
	
	public StockPrice findTopByCompanyCodeOrderByDateDesc(String companycode);
	
	public List<StockPrice> findAllByCompanyCodeAndDateBetween(String companyCode, Date start, Date end);
	
	public StockPrice findTopByCompanyCodeAndDateBetweenOrderByStockPriceDesc(String companyCode, Date start, Date end);
	
	public StockPrice findTopByCompanyCodeAndDateBetweenOrderByStockPriceAsc(String companyCode, Date start, Date end);

}

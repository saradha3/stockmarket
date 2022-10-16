package com.stockprice.services;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockprice.exceptions.ResourceNotFoundException;
import com.stockprice.models.StockPrice;
import com.stockprice.payloads.StockPriceDto;
import com.stockprice.repositories.StockPriceRepository;

@Service
public class StockPriceServiceImpl implements StockPriceService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private StockPriceRepository stockPriceRepository;

	@Override
	public StockPriceDto add(StockPriceDto stockPriceDto, String companyCode) {
		// TODO Auto-generated method stub
		StockPrice stockPrice = this.mapper.map(stockPriceDto, StockPrice.class);
		stockPrice.setCompanyCode(companyCode);
		Locale locale = new Locale("en");
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT,locale);
		Date date = new Date();
		String time = dateFormat.format(date);
		stockPrice.setDate(date);
		stockPrice.setTime(time);
		
		this.stockPriceRepository.save(stockPrice);
		return this.mapper.map(stockPrice, StockPriceDto.class);
	}

	//update stock price by stockpriceId
	@Override
	public StockPriceDto update(StockPriceDto stockPriceDto, int id) {
		// TODO Auto-generated method stub
		StockPrice sp = this.stockPriceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("StockPrice with id: "+id+" is not found"));
		sp.setCompanyCode(stockPriceDto.getCompanyCode());
		sp.setStockPrice(stockPriceDto.getStockPrice());
		Locale locale = new Locale("en");
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT,locale);
		Date date = new Date();
		String time = dateFormat.format(date);
		sp.setDate(date);
		sp.setTime(time);
		this.stockPriceRepository.save(sp);
		return this.mapper.map(sp, StockPriceDto.class);
	}
	
	//update stock price by company code
	@Override
	public List<StockPriceDto> updateByCompanyCode(StockPriceDto stockPriceDto, String companyCode) {
		// TODO Auto-generated method stub
		List<StockPrice> sp = this.stockPriceRepository.findAllByCompanyCode(companyCode);
		sp.stream().forEach(stockprice -> {
			stockprice.setCompanyCode(stockPriceDto.getCompanyCode());
			stockprice.setStockPrice(stockPriceDto.getStockPrice());
			Locale locale = new Locale("en");
			DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT,locale);
			Date date = new Date();
			String time = dateFormat.format(date);
			stockprice.setDate(date);
			stockprice.setTime(time);
			this.stockPriceRepository.save(stockprice);
		});
		
		List<StockPriceDto> updatedDtos = sp.stream().map(stockprice -> this.mapper.map(stockprice, StockPriceDto.class)).collect(Collectors.toList());
		return updatedDtos;
	}

	@Override
	public void deleteStockPriceById(int id) {
		// TODO Auto-generated method stub
		StockPrice sp = this.stockPriceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("StockPrice with id: "+id+" is not found"));
		this.stockPriceRepository.delete(sp);
		

	}

	@Override
	public void deleteStockPriceByCompany(String companyCode) {
		// TODO Auto-generated method stub
		System.out.println("inside deleteStockPriceByCompany");
		List<StockPrice> sp = this.stockPriceRepository.findAllByCompanyCode(companyCode);
		System.out.println("sp: "+sp);
		if(sp.isEmpty()) {
			throw new ResourceNotFoundException("StockPrice with companycode: "+companyCode+" is not found");
		}
		else {
			sp.stream().forEach(stockPrice -> this.stockPriceRepository.delete(stockPrice));
		}
		
		//this.stockPriceRepository.delete(sp);
	}

	@Override
	public StockPriceDto getLatestStockPriceOfCompany(String companycode) {
		// TODO Auto-generated method stub
		StockPrice latest = this.stockPriceRepository.findTopByCompanyCodeOrderByDateDesc(companycode);
		return this.mapper.map(latest, StockPriceDto.class);
	}

	@Override
	public List<StockPriceDto> getStockPriceBetween(String companycode, Date start, Date end) {
		// TODO Auto-generated method stub
		List<StockPrice> allCompanyCodeDateBetween = this.stockPriceRepository.findAllByCompanyCodeAndDateBetween(companycode, start, end);
		List<StockPriceDto> collectedDtos = allCompanyCodeDateBetween.stream().map(stockPrice -> this.mapper.map(stockPrice, StockPriceDto.class)).collect(Collectors.toList());
		return collectedDtos;
	}

	@Override
	public StockPriceDto getMaxStockPriceBetween(String companycode, Date start, Date end) {
		// TODO Auto-generated method stub
		StockPrice record = this.stockPriceRepository.findTopByCompanyCodeAndDateBetweenOrderByStockPriceDesc(companycode, start, end);
		return this.mapper.map(record, StockPriceDto.class);
	}

	@Override
	public StockPriceDto getMinStockPriceBetween(String companycode, Date start, Date end) {
		// TODO Auto-generated method stub
		StockPrice record = this.stockPriceRepository.findTopByCompanyCodeAndDateBetweenOrderByStockPriceAsc(companycode, start, end);
		return this.mapper.map(record, StockPriceDto.class);
	}



}

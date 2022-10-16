package com.stockprice.controllers;



import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockprice.payloads.ApiResponse;
import com.stockprice.payloads.StockPriceDto;
import com.stockprice.services.StockPriceService;

@RestController
@RequestMapping("/api/v1.0/market/stock")
public class StockPriceController {
	
	@Autowired
	private StockPriceService stockPriceService;
	
	@PostMapping("/add/{companyCode}")
	public ResponseEntity<StockPriceDto> addStockPrice(@RequestBody StockPriceDto stockPriceDto,@PathVariable String companyCode){
		System.out.println(stockPriceDto);
		StockPriceDto createdStockPrice = this.stockPriceService.add(stockPriceDto, companyCode);
		return new ResponseEntity<StockPriceDto>(createdStockPrice,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/stockpriceid/{id}")
	public ResponseEntity<StockPriceDto> updateStockPrice(@RequestBody StockPriceDto stockPriceDto,@PathVariable int id){
		StockPriceDto updatedStockPrice = this.stockPriceService.update(stockPriceDto, id);
		return new ResponseEntity<StockPriceDto>(updatedStockPrice,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/companycode/{companycode}")
	public ResponseEntity<List<StockPriceDto>> updateStockPriceByCompanyCode(@RequestBody StockPriceDto stockPriceDto,@PathVariable String companycode){
		List<StockPriceDto> updatedStockPrice = this.stockPriceService.updateByCompanyCode(stockPriceDto, companycode);
		return new ResponseEntity<List<StockPriceDto>>(updatedStockPrice,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/companycode/{companycode}")
	public ResponseEntity<ApiResponse> deleteStockPriceByCompany(@PathVariable String companycode){
		this.stockPriceService.deleteStockPriceByCompany(companycode);
		return new ResponseEntity<ApiResponse>(new ApiResponse("StockPrice for company code: "+companycode+" deleted successfully", true),HttpStatus.OK);
	}
	
	@GetMapping("/getlateststockprice/companycode/{companycode}")
	public ResponseEntity<StockPriceDto> getLatestStockPriceofCompany(@PathVariable String companycode){
		StockPriceDto latestStockPriceOfCompany = this.stockPriceService.getLatestStockPriceOfCompany(companycode);
		return new ResponseEntity<StockPriceDto>(latestStockPriceOfCompany,HttpStatus.OK);
	}
	
	@GetMapping("/getstockpricebetween/{message}")
	public ResponseEntity<List<StockPriceDto>> getAllStockPriceOfACompanyDatedBetween(@PathVariable String message) throws ParseException{
		String[] splitedStrings = message.split("&");
		String companyCode = splitedStrings[0];
		System.out.println(companyCode);
		System.out.println(splitedStrings[1]);
		SimpleDateFormat formatter =  new SimpleDateFormat("dd-MMM-yyyy");
		
		Date start = formatter.parse(splitedStrings[1]);
		System.out.println(start);
		Date end = formatter.parse(splitedStrings[2]);
		
		List<StockPriceDto> stockPriceBetween = this.stockPriceService.getStockPriceBetween(companyCode, start, end);
		return new ResponseEntity<List<StockPriceDto>>(stockPriceBetween,HttpStatus.OK);
	}
	
	@GetMapping("/getmaxstockpricebetween/{message}")
	public ResponseEntity<StockPriceDto> getMaxStockPriceOfACompanyDatedBetween(@PathVariable String message) throws ParseException{
		String[] splitedStrings = message.split("&");
		String companyCode = splitedStrings[0];
		System.out.println(companyCode);
		System.out.println(splitedStrings[1]);
		SimpleDateFormat formatter =  new SimpleDateFormat("dd-MMM-yyyy");
		
		Date start = formatter.parse(splitedStrings[1]);
		System.out.println(start);
		Date end = formatter.parse(splitedStrings[2]);
		
		StockPriceDto maxStockPriceBetween = this.stockPriceService.getMaxStockPriceBetween(companyCode, start, end);
		return new ResponseEntity<StockPriceDto>(maxStockPriceBetween,HttpStatus.OK);
	}
	
	@GetMapping("/getminstockpricebetween/{message}")
	public ResponseEntity<StockPriceDto> getMinStockPriceOfACompanyDatedBetween(@PathVariable String message) throws ParseException{
		String[] splitedStrings = message.split("&");
		String companyCode = splitedStrings[0];
		System.out.println(companyCode);
		System.out.println(splitedStrings[1]);
		SimpleDateFormat formatter =  new SimpleDateFormat("dd-MMM-yyyy");
		
		Date start = formatter.parse(splitedStrings[1]);
		System.out.println(start);
		Date end = formatter.parse(splitedStrings[2]);
		
		StockPriceDto minStockPriceBetween = this.stockPriceService.getMinStockPriceBetween(companyCode, start, end);
		return new ResponseEntity<StockPriceDto>(minStockPriceBetween,HttpStatus.OK);
	}

}

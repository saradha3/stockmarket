package com.stock.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePropertiesPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.payloads.ApiResponse;
import com.stock.payloads.CompanyDto;
import com.stock.services.CompanyService;

@Controller
@RequestMapping("/api/v1.0/market/company")
@CrossOrigin("*")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/register")
	public ResponseEntity<CompanyDto> register(@Valid @RequestBody CompanyDto companyDto){
		System.out.println(companyDto);
		CompanyDto createdCompany = this.companyService.create(companyDto);
		return new ResponseEntity<CompanyDto>(createdCompany,HttpStatus.CREATED);
	}
	
	@GetMapping("/info/{companycode}")
	public ResponseEntity<CompanyDto> getCompanyInfo(@PathVariable String companycode){
		CompanyDto companyInfo = this.companyService.getCompanyInfo(companycode);
		return new ResponseEntity<CompanyDto>(companyInfo,HttpStatus.OK);
	}
	
	@GetMapping("/info")
	public ResponseEntity<List<CompanyDto>> getAllCompaniesInfo(){
		List<CompanyDto> allCompaniesInfo = this.companyService.getAllCompaniesInfo();
		return new ResponseEntity<List<CompanyDto>>(allCompaniesInfo,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{companycode}")
	public ResponseEntity<ApiResponse> deleteCompany(@PathVariable String companycode){
		this.companyService.deleteCompany(companycode);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Resource deleted successfully", true),HttpStatus.OK);
	}
	
	

}

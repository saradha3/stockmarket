package com.stock.services;

import java.util.List;

import com.stock.payloads.CompanyDto;

public interface CompanyService {
	
	public CompanyDto create(CompanyDto companyDto);
	
	public CompanyDto getCompanyInfo(String companycode);
	
	public List<CompanyDto> getAllCompaniesInfo();
	
	public void deleteCompany(String companycode);

}

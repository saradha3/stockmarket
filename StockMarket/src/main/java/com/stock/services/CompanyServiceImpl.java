package com.stock.services;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.exceptions.ResourceNotFoundException;
import com.stock.models.Company;
import com.stock.payloads.CompanyDto;
import com.stock.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private SequenceGeneratorService sequence;
	
	@Override
	public CompanyDto create(CompanyDto companyDto) {
		// TODO Auto-generated method stub
		companyDto.setCompanyId(sequence.getSequenceNumber(Company.SEQUENCE_NAME));
		Company company = this.mapper.map(companyDto, Company.class);
		Company createdCompany = this.companyRepository.save(company);
		return this.mapper.map(createdCompany, CompanyDto.class);
	}

	@Override
	public CompanyDto getCompanyInfo(String companycode) {
		// TODO Auto-generated method stub
		Company company = this.companyRepository.findByCompanyCode(companycode).orElseThrow(()->new ResourceNotFoundException("Company with companycode: "+companycode+ " is not found"));
		return this.mapper.map(company, CompanyDto.class);
	}

	@Override
	public List<CompanyDto> getAllCompaniesInfo() {
		// TODO Auto-generated method stub
		List<Company> companies = this.companyRepository.findAll();
		List<CompanyDto> allCompaniesDto = companies.stream().map(company -> this.mapper.map(company, CompanyDto.class)).collect(Collectors.toList());
		return allCompaniesDto;
	}

	@Override
	public void deleteCompany(String companycode) {
		// TODO Auto-generated method stub
		this.companyRepository.deleteByCompanyCode(companycode);
		
	}

}

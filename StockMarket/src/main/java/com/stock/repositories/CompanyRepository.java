package com.stock.repositories;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stock.models.Company;


public interface CompanyRepository extends MongoRepository<Company, Integer> {
	
	public Optional<Company> findByCompanyCode(String companyCode);
	
	public void deleteByCompanyCode(String companycode);

}

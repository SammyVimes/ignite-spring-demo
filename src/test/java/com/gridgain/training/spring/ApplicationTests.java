package com.gridgain.training.spring;

import com.gridgain.training.spring.repository.CityRepository;
import com.gridgain.training.spring.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	@Test
	void countryRepositoryWorks() {
		System.out.println("count=" + countryRepository.findByPopulationGreaterThanOrderByPopulationDesc(100_000_000).size());
	}

	@Test
	void cityRepositoryWorks() {
		System.out.println("city = " + cityRepository.findById(34));

		System.out.println("top 5 = " + cityRepository.findTopXMostPopulatedCities(5));
	}

}

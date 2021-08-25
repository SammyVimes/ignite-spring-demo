package com.gridgain.training.spring.repository;

import java.util.List;
import com.gridgain.training.spring.model.Country;
import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;

@RepositoryConfig(cacheName = "Country", igniteInstance = "ignite")
@Repository
public interface CountryRepository extends IgniteRepository<Country, String> {
    List<Country> findByPopulationGreaterThanOrderByPopulationDesc(int population);
}


package com.gridgain.training.spring.repository;

import java.util.List;
import javax.cache.Cache;
import com.gridgain.training.spring.model.City;
import com.gridgain.training.spring.model.CityKey;
import com.gridgain.training.spring.model.CityProjection;
import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.Query;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;

@RepositoryConfig(cacheName = "City", igniteInstance = "ignite")
@Repository
public interface CityRepository extends IgniteRepository<City, CityKey> {

    Cache.Entry<CityKey, City> findById(int id);

    @Query("SELECT city.name as city, MAX(city.population) as population, country.name as country FROM country " +
        "JOIN city ON city.countrycode = country.code " +
        "GROUP BY city.name, country.name, city.population " +
        "ORDER BY city.population DESC LIMIT ?")
    List<CityProjection> findTopXMostPopulatedCities(int limit);

}


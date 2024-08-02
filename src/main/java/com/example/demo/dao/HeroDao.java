package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Hero;
import java.util.List;

public interface HeroDao extends JpaRepository<Hero, Long> {

	@Query(value = "SELECT * FROM hero WHERE  race = :race AND power = (SELECT MAX(power) FROM hero WHERE race = :race) ", nativeQuery = true)
	List<Hero> getTopHero(@Param("race") String race);

	@Query(value = "SELECT * FROM hero ORDER BY id ASC", nativeQuery = true)
	List<Hero> findAllOrderById();
}

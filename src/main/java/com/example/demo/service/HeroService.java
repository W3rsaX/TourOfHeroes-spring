package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.HeroEditor;
import com.example.demo.dao.HeroDao;
import com.example.demo.model.Hero;

@Service
public class HeroService {

	@Autowired
	private HeroDao heroDao;

	public Hero saveHero(Hero hero) {
		return heroDao.save(hero);
	}

	public List<Hero> getHeroes() {
		List<Hero> heroes = new ArrayList<>();
		heroDao.findAllOrderById().forEach(heroes::add);
		return heroes;
	}

	public List<Hero> getTopHero(String race) {
		List<Hero> heroes = new ArrayList<>();
		heroDao.getTopHero(race).forEach(heroes::add);
		return heroes;
	}

	public Hero getHeroes(Long heroId) {
		return heroDao.findById(heroId).orElseThrow();
	}

	public void deleteHero(Long heroId) {
		heroDao.deleteById(heroId);
	}

	public Hero updateHero(Hero hero) {
		heroDao.findById(hero.getId()).orElseThrow();
		return heroDao.save(hero);
	}
}

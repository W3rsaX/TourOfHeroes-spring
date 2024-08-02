package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Hero;
import com.example.demo.service.HeroService;
import com.example.demo.controller.HeroEditor;
import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("http://localhost:4200")
public class HeroController {

	@Autowired
	private HeroService heroService;

	@Autowired
	private HeroEditor heroEditor;

	@PostMapping("/hero/save")
	public Hero saveHero(@RequestBody Hero hero) {
		hero = heroEditor.firstUpper(hero);
		hero = heroEditor.genderController(hero);
		return heroService.saveHero(hero);
	}

	@GetMapping("/hero/get")
	public List<Hero> getHeroes() {
		return heroService.getHeroes();
	}

	@GetMapping("/hero/get/human")
	public List<Hero> getTopHeroHuman() {
		return heroService.getTopHero("Human");
	}

	@GetMapping("/hero/get/dwarf")
	public List<Hero> getTopHeroDwarf() {
		return heroService.getTopHero("Dwarf");
	}

	@GetMapping("/hero/get/elf")
	public List<Hero> getHeroesHumansElf() {
		return heroService.getTopHero("Elf");
	}

	@GetMapping("/hero/get/{heroId}")
	public Hero getHero(@PathVariable Long heroId) {
		return heroService.getHeroes(heroId);
	}

	@DeleteMapping("/hero/delete/{heroId}")
	public void deleteHero(@PathVariable Long heroId) {
		heroService.deleteHero(heroId);
	}

	@PutMapping("/hero/update")
	public Hero updateHero(@RequestBody Hero hero) {
		hero = heroEditor.firstUpper(hero);
		hero = heroEditor.genderController(hero);
		return heroService.updateHero(hero);
	}
	
	@GetMapping("/detail/{heroId}")
	public Hero getHeroDetail(@PathVariable Long heroId) {
		return heroService.getHeroes(heroId);
	}
}

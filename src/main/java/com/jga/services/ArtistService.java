package com.jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Artist;
import com.jga.repositories.ArtistRepository;

@RestController
public class ArtistService {
	
	@Autowired
	ArtistRepository artistRepository;
	
	@GetMapping("/api/artist")
	public List<Artist> 
	findAllArtists
	(@RequestParam(name="username", required=false) String username,
	 @RequestParam(name="username", required=false) String password) {
		if(username != null && password != null) {
			//return (List<Artists>) artistRepository.findArtistByCredentials(username, password);
		}
		if(username != null) {
			artistRepository.findArtistByUsername(username, password);
		}
		
		// System.out.println(artistRepository.findAll());
		return (List<Artist>) artistRepository.findAll();
	}
	
	/*
	@GetMapping("/api/artist/{artistId}")
	public Artist findArtistById(@PathVariable("artistId") int aid) {
		return artistRepository.findOne(aid);
	}
	*/
	@PostMapping("/api/artist")
	public Artist createArtist(@RequestBody Artist artist) {
		return artistRepository.save(artist);
	}
	
}

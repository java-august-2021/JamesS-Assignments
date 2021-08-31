package com.jamesgabbie.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgabbie.lookify.models.Song;
import com.jamesgabbie.lookify.repositories.SongRepository;

@Service
public class SongService {
	private SongRepository repo;
	
	public SongService(SongRepository repo) {
		this.repo = repo;
	}
	
	//Create
	public Song create(Song song) {
		return this.repo.save(song);
	}
	
	//Update
	public Song update(Song song) {
		return this.repo.save(song);
	}
	
	//Destroy
	public void deleteById(Long id) {
		this.repo.deleteById(id);
	}
	
	//Get All
	public List<Song> getAll() {
		return this.repo.findAll();
	}
	
	//Get One
	public Song getOne(Long id) {
		return this.repo.findById(id).orElse(null);
	}
	
	//View Playlist
	public List<Song> searchArtists(String search){
		return this.repo.findByArtistContaining(search);
	}
	
	//Order Ratings
	public List<Song> getTopTen(){
		return this.repo.findFirst10ByOrderByRatingDesc();
	}
	

}

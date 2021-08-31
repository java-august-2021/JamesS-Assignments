package com.jamesgabbie.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jamesgabbie.lookify.models.Song;
import com.jamesgabbie.lookify.services.SongService;


@Controller
public class HomeController {
	
	private SongService service;
	public HomeController(SongService service) {
		this.service = service;
	}
	
	//JSP Welcome
	@GetMapping("/")
	public String welcome() {
		return "welcome.jsp";
	}
	
	
	// JSP Dashboard
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {
		List<Song> allTheSongs = service.getAll();
		viewModel.addAttribute("allTheSongs", allTheSongs);
		return "dashboard.jsp";
	}
	
	// JSP New
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	// JSP Display
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model viewModel) {
		Song song = service.getOne(id);
		viewModel.addAttribute("song", song);
		return "display.jsp";
	}
	

	//JSP Playlist
	@GetMapping("/playlist/{search}")
	public String artistSearch(@PathVariable("search") String search, Model viewModel) {
		List<Song> artistSongs = service.searchArtists(search);
		viewModel.addAttribute("artistSongs", artistSongs);
		viewModel.addAttribute("search", search);
		System.out.println(artistSongs);
		return "playlist.jsp";
	}
	
	//JSP TopTen
	@GetMapping("search/topTen")
	public String topTen(Model viewModel) {
		List<Song> topSongs = service.getTopTen();
		viewModel.addAttribute("topSongs", topSongs);
		
		
		return "topTen.jsp";
	}
	
	
	// Search
	@PostMapping("/search")
	public String search(RedirectAttributes redirectAttributes, @RequestParam("search") String search) {
		redirectAttributes.addAttribute("search", search);
		
		return "redirect:/playlist/{search}";
	}
	
	
	
	// Create 
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			service.create(song);
			return "redirect:/dashboard";
		}
	}
	
	// Delete
	@DeleteMapping("/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		service.deleteById(id);
		return "redirect:/dashboard";
	}
}

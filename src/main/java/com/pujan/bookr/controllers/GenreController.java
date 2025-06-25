package com.pujan.bookr.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pujan.bookr.payloads.ApiResponse;
import com.pujan.bookr.payloads.GenreDto;
import com.pujan.bookr.services.GenreService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/genres")
public class GenreController {

	@Autowired
	private GenreService genreService;

	// create
	@PostMapping("/")
	public ResponseEntity<GenreDto> createGenre(@Valid @RequestBody GenreDto genreDto) {
		GenreDto createGenre = this.genreService.createGenre(genreDto);
		return new ResponseEntity<GenreDto>(createGenre, HttpStatus.CREATED);
	}

	// update
	@PutMapping("/{genId}")
	public ResponseEntity<GenreDto> updateGenre(@Valid @RequestBody GenreDto genreDto, @PathVariable Integer genId) {
		GenreDto updatedGenre = this.genreService.updateGenre(genreDto, genId);
		return new ResponseEntity<GenreDto>(updatedGenre, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/{genId}")
	public ResponseEntity<ApiResponse> deleteGenre(@PathVariable Integer genId) {
		this.genreService.deleteGenre(genId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}

	// get
	@GetMapping("/{genId}")
	public ResponseEntity<GenreDto> getGenre(@PathVariable Integer genId) {
		GenreDto genreDto = this.genreService.getGenre(genId);
		return new ResponseEntity<GenreDto>(genreDto, HttpStatus.OK);

	}

	// get all
	@GetMapping("/")
	public ResponseEntity<List<GenreDto>> getGenres() {
		List<GenreDto> genres = this.genreService.getGenres();
		return ResponseEntity.ok(genres);
	}
}

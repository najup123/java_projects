package com.pujan.bookr.services;



import java.util.List;

import com.pujan.bookr.payloads.GenreDto;


public interface GenreService {
	
	// create
	GenreDto createGenre(GenreDto genreDto);
	
	// update
	GenreDto updateGenre(GenreDto genreDto, Integer genreId);
	
	// delete
	void deleteGenre(Integer categoryId);
	
	// get
	GenreDto getGenre(Integer categoryId);
	
	// get All
	List<GenreDto> getGenres();
}

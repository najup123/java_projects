package com.pujan.bookr.services.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pujan.bookr.entities.Genre;
import com.pujan.bookr.exceptions.ResourceNotFoundException;
import com.pujan.bookr.payloads.GenreDto;
import com.pujan.bookr.repositories.GenreRepo;
import com.pujan.bookr.services.GenreService;


@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private GenreRepo genreRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public GenreDto createGenre(GenreDto genreDto) {
		Genre gen = this.modelMapper.map(genreDto, Genre.class);
		Genre addedGen = this.genreRepo.save(gen);
		return this.modelMapper.map(addedGen, GenreDto.class);
	}

	@Override
	public GenreDto updateGenre(GenreDto genreDto, Integer genreId) {
		Genre gen = this.genreRepo.findById(genreId)
				.orElseThrow(()-> new ResourceNotFoundException("Genre ","Genre Id",genreId));
		
		gen.setGenreTitle(genreDto.getGenreTitle());
		gen.setGenreDescription(genreDto.getGenreDescription());
		
		Genre updatedGen = this.genreRepo.save(gen);
		
		return this.modelMapper.map(updatedGen, GenreDto.class);
	}

	@Override
	public void deleteGenre(Integer genreId) {
		Genre gen = this.genreRepo.findById(genreId).orElseThrow(() -> new ResourceNotFoundException("Genre ", "Genre id", genreId));
		this.genreRepo.delete(gen);
	}

	@Override
	public GenreDto getGenre(Integer genreId) {
		Genre gen=this.genreRepo.findById(genreId).orElseThrow(()-> new ResourceNotFoundException("Genre", "Genre id", genreId));
		return this.modelMapper.map(gen, GenreDto.class);
	}

	@Override
	public List<GenreDto> getGenres() {
		List<Genre> genres = this.genreRepo.findAll();
		List<GenreDto> genDtos = genres.stream().map((gen)-> this.modelMapper.map(gen, GenreDto.class)).collect(Collectors.toList());
		return genDtos;
	}
}
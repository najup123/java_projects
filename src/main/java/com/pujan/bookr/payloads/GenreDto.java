package com.pujan.bookr.payloads;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GenreDto {
	
	private Integer genreId;
	
	@NotBlank
	@Size(min=4)
	private String genreTitle;
	
	@NotBlank
	@Size(min=10)
	private String genreDescription;
	
}


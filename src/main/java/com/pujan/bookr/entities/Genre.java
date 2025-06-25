package com.pujan.bookr.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="genres")
@NoArgsConstructor
@Getter
@Setter
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genreId;
	
	@Column(name="title", length = 100, nullable = false)
	private String genreTitle;
	
	@Column(name="description")
	private String genreDescription;

}
package org.louakfaoui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
	private String title;
	private Integer episodeId;
	private String openingCrawl;
	private String director;
	private String producer;
	private Date releaseDate;
	private List<String> characters;
	private List<String> starships;
	private Date created;
	private Date edited;
	private String url;
}


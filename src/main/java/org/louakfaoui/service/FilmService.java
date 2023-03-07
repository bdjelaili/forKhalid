package org.louakfaoui.service;


import lombok.Data;
import org.louakfaoui.dto.FilmDTO;
import org.louakfaoui.jpa.entity.Film;
import org.louakfaoui.jpa.repository.FilmRepository;
import org.louakfaoui.mapper.BasicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FilmService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private FilmRepository filmRepository;
	/*@Autowired
	private org.louakfaoui.jpa.repository.PeopleRepository peopleRepository;*/
	@Value("${starwarsapi.baseurl}")
	private String baseUrl;

	@Transactional
	public void saveAllFilm() {
		String url = baseUrl + "/films/";
		FilmResponse body = restTemplate.exchange(
						url,
						HttpMethod.GET,
						null,
						FilmResponse.class)
				.getBody();

		List<Film> films =
				Objects.requireNonNull(body).getResults()
						.stream()
						.map(f -> BasicMapper.BASIC_MAPPER.map(f, Film.class))
						.collect(Collectors.toList());

		filmRepository.saveAll(films);
	}

	@Data
	private static class FilmResponse {
		private List<FilmDTO> results;
		private String next;
	}


}

package org.louakfaoui.service;

import lombok.Data;
import org.louakfaoui.jpa.entity.Starship;
import org.louakfaoui.jpa.repository.StarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StarshipService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private StarshipRepository starshipRepository;
	@Value("${starwarsapi.baseurl}")
	private String baseUrl;

	public List<Starship> getAllStarship() {
		String url = baseUrl + "/starships/";

		do {
			ResponseEntity<StarshipResponse> responseEntity = restTemplate.exchange(
					url,
					HttpMethod.GET,
					null,
					StarshipResponse.class
			);

			return responseEntity.getBody().getResults();

		} while (url != null);

	}

	@Transactional
	public void saveAllStarship() {
		List<Starship> starship = getAllStarship();
		starshipRepository.saveAll(starship);
	}

	@Data
	private static class StarshipResponse {
		private List<Starship> results;
		private String next;
	}
}

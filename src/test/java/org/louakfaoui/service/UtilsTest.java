package org.louakfaoui.service;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

	@Test
	public void extractId() {
		assertThat(Utils.extractId("https://swapi.py4e.com/api/films/1/")).isEqualTo(1L);
	}
}
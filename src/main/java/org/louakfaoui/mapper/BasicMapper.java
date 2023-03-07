package org.louakfaoui.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.louakfaoui.dto.FilmDTO;
import org.louakfaoui.jpa.entity.Film;
import org.louakfaoui.service.Utils;

public class BasicMapper extends ConfigurableMapper {

	public static final BasicMapper BASIC_MAPPER = new BasicMapper();

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(FilmDTO.class, Film.class)
				.field("characters", "people.url")
				.field("starships", "starships.url")
				.customize(new CustomMapper<FilmDTO, Film>() {
					@Override
					public void mapAtoB(FilmDTO dto, Film film, MappingContext context) {
						film.setId(Utils.extractId(dto.getUrl()));
						film.getPeople().forEach(p -> p.setId(Utils.extractId(p.getUrl())));
						film.getStarships().forEach(s -> s.setId(Utils.extractId(s.getUrl())));
					}
				})
				.byDefault()
				.register();
	}
}

package gg.bayes.challenge.dao.mapper;

import gg.bayes.challenge.parser.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class EventMapperProvider {

	private final Map<Class, EventMapper> mappers;

	{
		mappers = new HashMap<>();
		mappers.put(KillParsedEvent.class, new KillEventMapper());
		mappers.put(HitParsedEvent.class, new HitEventMapper());
		mappers.put(BuyParsedEvent.class, new BuyEventMapper());
		mappers.put(CastParsedEvent.class, new CastEventMapper());
	}


	public EventMapper getMapper(ParsedEvent event) {
		EventMapper eventMapper = mappers.get(event.getClass());
		if (eventMapper == null) {
			log.error("No mapper found for event of class {}", event.getClass().getSimpleName());
		}
		return eventMapper;
	}

}

package gg.bayes.challenge.dao.mapper;


import gg.bayes.challenge.dao.entity.CastEventEntity;
import gg.bayes.challenge.parser.model.CastParsedEvent;
import gg.bayes.challenge.parser.model.ParsedEvent;
import gg.bayes.challenge.util.TimestampUtils;

public class CastEventMapper implements EventMapper{

	@Override
	public CastEventEntity toEntity(ParsedEvent event) {
		CastParsedEvent castParsedEvent = (CastParsedEvent) event;
		CastEventEntity entity = new CastEventEntity();
		entity.setSourceHero(castParsedEvent.getSourceHero());
		entity.setActionObject(castParsedEvent.getActionObject());
		entity.setLevel(castParsedEvent.getLevel());
		entity.setMatchTimeMillis(TimestampUtils.tsToMillis(event.getTimestamp()));
		return entity;
	}
}

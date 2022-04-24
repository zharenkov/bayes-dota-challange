package gg.bayes.challenge.dao.mapper;

import gg.bayes.challenge.dao.entity.KillEventEntity;
import gg.bayes.challenge.parser.model.KillParsedEvent;
import gg.bayes.challenge.parser.model.ParsedEvent;
import gg.bayes.challenge.util.TimestampUtils;

public class KillEventMapper implements EventMapper {

	@Override
	public KillEventEntity toEntity(ParsedEvent event) {
		KillParsedEvent killEvent = (KillParsedEvent) event;
		KillEventEntity entity = new KillEventEntity();
		entity.setSourceHero(killEvent.getSourceHero());
		entity.setTargetHero(killEvent.getTargetHero());
		entity.setMatchTimeMillis(TimestampUtils.tsToMillis(event.getTimestamp()));
		return entity;
	}
}

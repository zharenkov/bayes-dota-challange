package gg.bayes.challenge.dao.mapper;

import gg.bayes.challenge.dao.entity.HitEventEntity;
import gg.bayes.challenge.parser.model.HitParsedEvent;
import gg.bayes.challenge.parser.model.ParsedEvent;
import gg.bayes.challenge.util.TimestampUtils;

public class HitEventMapper implements EventMapper {

	@Override
	public HitEventEntity toEntity(ParsedEvent event) {
		HitParsedEvent hitParsedEvent = (HitParsedEvent)  event;
		HitEventEntity entity = new HitEventEntity();
		entity.setSourceHero(hitParsedEvent.getSourceHero());
		entity.setTargetHero(hitParsedEvent.getTargetHero());
		entity.setDamage(hitParsedEvent.getDamage());
		entity.setActionObject(hitParsedEvent.getActionObject());
		entity.setMatchTimeMillis(TimestampUtils.tsToMillis(event.getTimestamp()));
		return entity;
	}
}

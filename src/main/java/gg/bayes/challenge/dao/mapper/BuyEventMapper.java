package gg.bayes.challenge.dao.mapper;

import gg.bayes.challenge.dao.entity.BuyEventEntity;
import gg.bayes.challenge.parser.model.BuyParsedEvent;
import gg.bayes.challenge.parser.model.ParsedEvent;
import gg.bayes.challenge.util.TimestampUtils;

public class BuyEventMapper implements EventMapper{

	@Override
	public BuyEventEntity toEntity(ParsedEvent event) {
		BuyParsedEvent buyParsedEvent = (BuyParsedEvent) event;
		BuyEventEntity entity = new BuyEventEntity();
		entity.setSourceHero(buyParsedEvent.getSourceHero());
		entity.setActionObject(buyParsedEvent.getActionObject());
		entity.setMatchTimeMillis(TimestampUtils.tsToMillis(event.getTimestamp()));
		return entity;
	}
}

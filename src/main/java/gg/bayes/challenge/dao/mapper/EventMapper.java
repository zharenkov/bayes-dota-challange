package gg.bayes.challenge.dao.mapper;

import gg.bayes.challenge.dao.entity.EventEntity;
import gg.bayes.challenge.parser.model.ParsedEvent;

public interface EventMapper {

	EventEntity toEntity(ParsedEvent event);
}

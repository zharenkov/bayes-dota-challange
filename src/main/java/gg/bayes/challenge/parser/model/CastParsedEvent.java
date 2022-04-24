package gg.bayes.challenge.parser.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CastParsedEvent extends ParsedEvent{
	private String sourceHero;
	private String actionObject;
	private Integer level;

	@Builder
	public CastParsedEvent(String timestamp, String sourceHero, String actionObject, Integer level) {
		super(timestamp);
		this.sourceHero = sourceHero;
		this.actionObject = actionObject;
		this.level = level;
	}
}

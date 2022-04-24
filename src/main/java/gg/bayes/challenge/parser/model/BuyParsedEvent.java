package gg.bayes.challenge.parser.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BuyParsedEvent extends ParsedEvent {
	private String sourceHero;
	private String actionObject;

	@Builder
	public BuyParsedEvent(String timestamp, String sourceHero, String actionObject) {
		super(timestamp);
		this.sourceHero = sourceHero;
		this.actionObject = actionObject;
	}
}

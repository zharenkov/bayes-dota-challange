package gg.bayes.challenge.parser.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class KillParsedEvent extends ParsedEvent{
	private String sourceHero;
	private String targetHero;

	@Builder
	public KillParsedEvent(String timestamp, String sourceHero, String targetHero) {
		super(timestamp);
		this.sourceHero = sourceHero;
		this.targetHero = targetHero;
	}
}

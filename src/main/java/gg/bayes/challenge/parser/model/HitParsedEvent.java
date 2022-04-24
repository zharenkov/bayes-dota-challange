package gg.bayes.challenge.parser.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class HitParsedEvent extends ParsedEvent{
	private String sourceHero;
	private String targetHero;
	private String actionObject;
	private Integer damage;

	@Builder
	public HitParsedEvent(String timestamp, String sourceHero, String targetHero, String actionObject, Integer damage) {
		super(timestamp);
		this.sourceHero = sourceHero;
		this.targetHero = targetHero;
		this.actionObject = actionObject;
		this.damage = damage;
	}
}

package gg.bayes.challenge.parser;

import gg.bayes.challenge.parser.model.ParsedEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public abstract class AbstractEventParser implements EventParser {

	protected Pattern parsePattern;

	@Override
	public List<ParsedEvent> parse(String payload) {
		List<ParsedEvent> parsedEvents = new ArrayList<>();
		Matcher matcher = parsePattern.matcher(payload);
		while (matcher.find()) {
			ParsedEvent parsedEvent = extractEvent(matcher);
			if (parsedEvent != null) {
				parsedEvents.add(parsedEvent);
			} else {
				log.warn("Failed to parse event: {}", matcher.group());
			}
		}
		return parsedEvents;
	}

	public abstract ParsedEvent extractEvent(Matcher matcher);
}

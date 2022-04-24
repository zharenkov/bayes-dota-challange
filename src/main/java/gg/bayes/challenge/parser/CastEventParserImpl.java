package gg.bayes.challenge.parser;

import gg.bayes.challenge.parser.model.CastParsedEvent;
import gg.bayes.challenge.parser.model.ParsedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.valueOf;

@Component
public class CastEventParserImpl extends AbstractEventParser {

	@Override
	public ParsedEvent extractEvent(Matcher matcher) {
		if (matcher.groupCount() == 4) {
			return CastParsedEvent.builder()
					.timestamp(matcher.group(1))
					.sourceHero(matcher.group(2))
					.actionObject(matcher.group(3))
					.level(valueOf(matcher.group(4)))
					.build();
		}
		return null;
	}

	@Value(value = "${bayes.dota.parser.regex.cast}")
	private void setParsePattern(String regex) {
		parsePattern = Pattern.compile(regex);
	}
}

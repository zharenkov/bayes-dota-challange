package gg.bayes.challenge.parser;

import gg.bayes.challenge.parser.model.KillParsedEvent;
import gg.bayes.challenge.parser.model.ParsedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class KillEventParser extends AbstractEventParser {

	@Override
	public ParsedEvent extractEvent(Matcher matcher) {
		if (matcher.groupCount() == 3) {
			return KillParsedEvent.builder()
					.timestamp(matcher.group(1))
					.sourceHero(matcher.group(3))
					.targetHero(matcher.group(2))
					.build();
		}
		return null;
	}

	@Value(value = "${bayes.dota.parser.regex.kill}")
	private void setParsePattern(String regex) {
		parsePattern = Pattern.compile(regex);
	}
}

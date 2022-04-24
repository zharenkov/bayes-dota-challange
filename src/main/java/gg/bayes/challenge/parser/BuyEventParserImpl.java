package gg.bayes.challenge.parser;

import gg.bayes.challenge.parser.model.BuyParsedEvent;
import gg.bayes.challenge.parser.model.KillParsedEvent;
import gg.bayes.challenge.parser.model.ParsedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BuyEventParserImpl extends AbstractEventParser {

	@Override
	public ParsedEvent extractEvent(Matcher matcher) {
		if (matcher.groupCount() == 3) {
			return BuyParsedEvent.builder()
					.timestamp(matcher.group(1))
					.sourceHero(matcher.group(2))
					.actionObject(matcher.group(3))
					.build();
		}
		return null;
	}

	@Value(value = "${bayes.dota.parser.regex.buy}")
	private void setParsePattern(String regex) {
		parsePattern = Pattern.compile(regex);
	}
}

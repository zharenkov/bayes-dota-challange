package gg.bayes.challenge.parser;

import gg.bayes.challenge.parser.model.HitParsedEvent;
import gg.bayes.challenge.parser.model.KillParsedEvent;
import gg.bayes.challenge.parser.model.ParsedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.valueOf;

@Component
public class HitEventParserImpl extends AbstractEventParser{

	@Override
	public ParsedEvent extractEvent(Matcher matcher) {
		if (matcher.groupCount() == 5) {
			return HitParsedEvent.builder()
					.timestamp(matcher.group(1))
					.sourceHero(matcher.group(2))
					.targetHero(matcher.group(3))
					.actionObject(matcher.group(4))
					.damage(valueOf(matcher.group(5)))
					.build();
		}
		return null;
	}

	@Value(value = "${bayes.dota.parser.regex.hit}")
	private void setParsePattern (String regex) {
		parsePattern = Pattern.compile(regex);
	}
}

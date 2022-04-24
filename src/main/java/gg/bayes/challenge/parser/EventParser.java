package gg.bayes.challenge.parser;

import gg.bayes.challenge.parser.model.ParsedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventParser {

	List<ParsedEvent> parse(String payload);
}

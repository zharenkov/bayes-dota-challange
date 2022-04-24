package gg.bayes.challenge.dao;

import gg.bayes.challenge.parser.model.ParsedEvent;

import javax.persistence.Tuple;
import java.util.List;

public interface MatchDaoService {

	Long saveMatch(List<ParsedEvent> events);

	List<Tuple> getMatchKillsPerHero(Long matchId);

	List<Tuple> getBoughtItems(Long matchId, String sourceHero);

	List<Tuple> countCasts(Long matchId, String sourceHero);

	List<Tuple> countDamagePerEnemy(Long matchId, String sourceHero);
}

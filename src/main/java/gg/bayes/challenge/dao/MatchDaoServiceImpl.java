package gg.bayes.challenge.dao;

import gg.bayes.challenge.dao.entity.EventEntity;
import gg.bayes.challenge.dao.entity.MatchEntity;
import gg.bayes.challenge.dao.mapper.EventMapperProvider;
import gg.bayes.challenge.dao.repository.EventRepository;
import gg.bayes.challenge.dao.repository.MatchRepository;
import gg.bayes.challenge.parser.model.ParsedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MatchDaoServiceImpl implements MatchDaoService {

	private MatchRepository matchRepository;
	private EventRepository eventRepository;
	private EventMapperProvider eventMapperProvider;

	@Autowired
	public MatchDaoServiceImpl(MatchRepository matchRepository, EventRepository eventRepository, EventMapperProvider eventMapperProvider) {
		this.matchRepository = matchRepository;
		this.eventRepository = eventRepository;
		this.eventMapperProvider = eventMapperProvider;
	}

	@Override
	public Long saveMatch(List<ParsedEvent> events) {
		MatchEntity matchEntity = new MatchEntity();
		List<EventEntity> eventEntities = events.parallelStream()
				.map(event -> {
					var mapper = eventMapperProvider.getMapper(event);
					return mapper != null ? mapper.toEntity(event) : null;
				})
				.filter(Objects::nonNull)
				.sorted(Comparator.comparingLong(EventEntity::getMatchTimeMillis))
				.collect(Collectors.toList());
		matchEntity.getEvents().addAll(eventEntities);
		return matchRepository.save(matchEntity).getMatchId();
	}

	public List<Tuple> getMatchKillsPerHero(Long matchId) {
		return eventRepository.getMatchKillsPerHero(matchId);
	}

	@Override
	public List<Tuple> getBoughtItems(Long matchId, String sourceHero) {
		return eventRepository.getBoughtItems(matchId, sourceHero);
	}

	@Override
	public List<Tuple> countCasts(Long matchId, String sourceHero) {
		return eventRepository.countCasts(matchId, sourceHero);
	}

	@Override
	public List<Tuple> countDamagePerEnemy(Long matchId, String sourceHero) {
		return eventRepository.countDamagePerEnemy(matchId, sourceHero);
	}
}

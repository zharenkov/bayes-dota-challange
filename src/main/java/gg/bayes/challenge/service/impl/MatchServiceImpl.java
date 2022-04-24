package gg.bayes.challenge.service.impl;

import gg.bayes.challenge.dao.MatchDaoService;
import gg.bayes.challenge.parser.EventParser;
import gg.bayes.challenge.parser.model.ParsedEvent;
import gg.bayes.challenge.rest.model.HeroDamage;
import gg.bayes.challenge.rest.model.HeroItems;
import gg.bayes.challenge.rest.model.HeroKills;
import gg.bayes.challenge.rest.model.HeroSpells;
import gg.bayes.challenge.service.MatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class MatchServiceImpl implements MatchService {

    List<EventParser> parsers;
    MatchDaoService matchDaoService;

    @Autowired
    public MatchServiceImpl(List<EventParser> parsers, MatchDaoService matchDaoService) {
        this.parsers = parsers;
        this.matchDaoService = matchDaoService;
    }

    @Override
    public Long ingestMatch(String payload) {
        List<ParsedEvent> events = new ArrayList<>();
        parsers.parallelStream().forEach(parser -> events.addAll(parser.parse(payload)));
        return matchDaoService.saveMatch(events);
    }

    @Override
    public List<HeroKills> getMatchKillsPerHero(Long matchId) {
        return matchDaoService.getMatchKillsPerHero(matchId).stream().map(HeroKills::from).collect(toList());
    }

    @Override
    public List<HeroItems> getBoughtItems(Long matchId, String sourceHero) {
        return matchDaoService.getBoughtItems(matchId, sourceHero).stream().map(HeroItems::from).collect(toList());
    }

    @Override
    public List<HeroSpells> countCasts(Long matchId, String sourceHero) {
        return matchDaoService.countCasts(matchId, sourceHero).stream().map(HeroSpells::from).collect(toList());
    }

    @Override
    public List<HeroDamage> countDamagePerEnemy(Long matchId, String sourceHero) {
        return matchDaoService.countDamagePerEnemy(matchId, sourceHero).stream().map(HeroDamage::from).collect(toList());
    }
}

package gg.bayes.challenge.service;

import gg.bayes.challenge.rest.model.HeroDamage;
import gg.bayes.challenge.rest.model.HeroItems;
import gg.bayes.challenge.rest.model.HeroKills;
import gg.bayes.challenge.rest.model.HeroSpells;

import java.util.List;

public interface MatchService {
    Long ingestMatch(String payload);
    List<HeroKills> getMatchKillsPerHero(Long matchId);
    List<HeroItems> getBoughtItems(Long matchId, String sourceHero);
    List<HeroSpells> countCasts(Long matchId, String sourceHero);
    List<HeroDamage> countDamagePerEnemy(Long matchId, String sourceHero);
}

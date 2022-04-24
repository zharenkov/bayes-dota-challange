package gg.bayes.challenge.dao.repository;

import gg.bayes.challenge.dao.entity.EventEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Long> {

	@Query(value = "select e.sourceHero, count(e) from killEvent e where e.matchId=?1 group by e.sourceHero")
	List<Tuple> getMatchKillsPerHero(Long matchId);

	@Query(value = "select e.actionObject, e.matchTimeMillis from buyEvent e where e.matchId=?1 and e.sourceHero=?2")
	List<Tuple> getBoughtItems(Long matchId, String sourceHero);

	@Query(value = "select e.actionObject, count(e) from castEvent e where e.matchId=?1 and e.sourceHero=?2 group by e.actionObject")
	List<Tuple> countCasts(Long matchId, String sourceHero);


	@Query(value = "select e.targetHero, count(e), sum(e.damage) from hitEvent e where e.matchId=?1 and e.sourceHero=?2 group by e.targetHero")
	List<Tuple> countDamagePerEnemy(Long matchId, String sourceHero);
}

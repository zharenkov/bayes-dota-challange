package gg.bayes.challenge.dao.repository;

import gg.bayes.challenge.dao.entity.MatchEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<MatchEntity, Long> {
}

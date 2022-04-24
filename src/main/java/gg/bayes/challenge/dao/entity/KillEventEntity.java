package gg.bayes.challenge.dao.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "killEvent")
@DiscriminatorValue("KILL")
public class KillEventEntity extends TwoParticipantEventEntity{

}

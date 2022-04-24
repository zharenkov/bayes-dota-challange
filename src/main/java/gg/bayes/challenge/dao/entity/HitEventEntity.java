package gg.bayes.challenge.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity(name = "hitEvent")
@DiscriminatorValue("HIT")
public class HitEventEntity extends TwoParticipantEventEntity {

	@Column(name = "DAMAGE")
	private Integer damage;


}

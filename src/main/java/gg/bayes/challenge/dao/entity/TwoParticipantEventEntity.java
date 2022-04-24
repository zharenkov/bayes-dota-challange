package gg.bayes.challenge.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public abstract class TwoParticipantEventEntity extends EventEntity{

	@Column(name = "TARGET_HERO")
	private String targetHero;

}

package gg.bayes.challenge.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity(name = "castEvent")
@DiscriminatorValue("CAST")
public class CastEventEntity extends EventEntity{

	@Column(name = "ABILITY_LVL")
	private Integer level;

}

package gg.bayes.challenge.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EVENT_TYPE")
@Table(name = "EVENT_TAB")
@Entity(name = "event")
public abstract class EventEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EVENT_ID")
	private Long eventId;

	@Column(name = "MATCH_TIME_MS")
	private Long matchTimeMillis;

	@Column(name = "SOURCE_HERO")
	private String sourceHero;

	@Column(name = "ACTION_OBJECT")
	private String actionObject;

	@Column(name = "MATCH_ID", updatable = false, insertable = false)
	private Long matchId;

	@Column(name = "EVENT_TYPE", updatable = false, insertable = false)
	private String eventType;
}

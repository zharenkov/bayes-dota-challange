package gg.bayes.challenge.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "match")
@Table(name = "MATCH_TAB")
@Data
public class MatchEntity {

	@PrePersist
	private void prepersist() {
		ingestTime = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long matchId;

	@Column(name = "INGEST_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ingestTime;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MATCH_ID", nullable = false)
	private List<EventEntity> events = new ArrayList<>();

}

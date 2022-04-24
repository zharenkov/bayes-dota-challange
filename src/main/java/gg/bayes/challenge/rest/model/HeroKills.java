package gg.bayes.challenge.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Tuple;

@Data
public class HeroKills {
    private String hero;
    private Integer kills;

    public static HeroKills from(Tuple tuple) {
        HeroKills h = new HeroKills();
        h.setHero(tuple.get(0, String.class));
        h.setKills(tuple.get(1, Long.class).intValue());
        return h;
    }
}

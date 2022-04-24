package gg.bayes.challenge.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Tuple;

@Data
public class HeroSpells {
    private String spell;
    private Integer casts;

    public static HeroSpells from(Tuple tuple) {
        HeroSpells h = new HeroSpells();
        h.setSpell(tuple.get(0, String.class));
        h.setCasts(tuple.get(1, Long.class).intValue());
        return h;
    }
}

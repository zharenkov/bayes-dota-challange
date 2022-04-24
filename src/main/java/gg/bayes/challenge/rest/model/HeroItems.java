package gg.bayes.challenge.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Tuple;

@Data
public class HeroItems {
    private String item;
    private Long timestamp;

    public static HeroItems from(Tuple tuple) {
        HeroItems h = new HeroItems();
        h.setItem(tuple.get(0, String.class));
        h.setTimestamp(tuple.get(1, Long.class));
        return h;
    }
}

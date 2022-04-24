package gg.bayes.challenge.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Tuple;

@Data
public class HeroDamage {
    private String target;
    @JsonProperty("damage_instances")
    private Integer damageInstances;
    @JsonProperty("total_damage")
    private Integer totalDamage;

    public static HeroDamage from(Tuple tuple) {
        HeroDamage h = new HeroDamage();
        h.setTarget(tuple.get(0, String.class));
        h.setDamageInstances(tuple.get(1, Long.class).intValue());
        h.setTotalDamage(tuple.get(2, Long.class).intValue());
        return h;
    }
}

package gg.bayes.challenge.dao.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "buyEvent")
@DiscriminatorValue("BUY")
public class BuyEventEntity extends EventEntity{


}

package shop.calciostore.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;
    private Long soccerTeamId;
    private Date beginDate;
    private Date endDate;

}

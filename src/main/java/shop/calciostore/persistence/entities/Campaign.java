package shop.calciostore.persistence.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long soccerTeamId;
    private Date beginDate;
    private Date endDate;

}

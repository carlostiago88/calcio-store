package shop.calciostore.persistence.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long soccerTeamId;
    private Date beginDate;
    private Date endDate;

    public Campaign(){

    }

    public Campaign(String name, Long soccerTeamId, Date beginDate, Date endDate) {
        this.name = name;
        this.soccerTeamId = soccerTeamId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSoccerTeamId() {
        return soccerTeamId;
    }

    public void setSoccerTeamId(Long soccerTeamId) {
        this.soccerTeamId = soccerTeamId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

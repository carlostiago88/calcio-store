package shop.calciostore.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private SoccerTeam soccerTeam;
    private Date beginDate;
    private Date endDate;

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SoccerTeam getSoccerTeam() {
        return soccerTeam;
    }

    public void setSoccerTeam(SoccerTeam soccerTeam) {
        this.soccerTeam = soccerTeam;
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

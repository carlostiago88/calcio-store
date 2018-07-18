package shop.calciostore.persistence.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long soccerTeamId;
    private Date beginDate;
    private Date endDate;

    public Campaign(){

    }

    public Campaign(Long soccerTeamId) {
        this.soccerTeamId = soccerTeamId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campaign)) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(getId(), campaign.getId()) &&
                Objects.equals(getSoccerTeamId(), campaign.getSoccerTeamId()) &&
                Objects.equals(getBeginDate(), campaign.getBeginDate()) &&
                Objects.equals(getEndDate(), campaign.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSoccerTeamId(), getBeginDate(), getEndDate());
    }
}

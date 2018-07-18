package shop.calciostore.persistence.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class CampaignHistoric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long campaignId;
    private Date updatedAt;
    private String key; // column
    private String oldValue;
    private String newValue;

    public CampaignHistoric() {
    }

    public CampaignHistoric(Long campaignId, Date updatedAt, String key, String oldValue, String newValue) {
        this.campaignId = campaignId;
        this.updatedAt = updatedAt;
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        return "CampaignHistoric{" +
                "id=" + id +
                ", campaignId=" + campaignId +
                ", updatedAt=" + updatedAt +
                ", key='" + key + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                '}';
    }
}

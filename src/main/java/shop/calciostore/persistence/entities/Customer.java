package shop.calciostore.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private Long soccerTeamId;
    private String name;
    private Date dateOfBirth;
    @Column(unique = true)
    private String email;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<CustomersCampaigns> customersCampaigns;

    public List<CustomersCampaigns> getCustomersCampaigns() {
        return customersCampaigns;
    }

    public void setCustomersCampaigns(List<CustomersCampaigns> customersCampaigns) {
        this.customersCampaigns = customersCampaigns;
    }

    public Customer() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

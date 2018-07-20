package shop.calciostore.persistence.entities;

import javax.persistence.*;
@Entity
@Table(name = "customers_campaigns")
public class CustomersCampaigns {
    @Id
    @GeneratedValue
    @Column(name = "customer_campaign_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    public CustomersCampaigns(Customer customer, Campaign campaign) {
        this.customer = customer;
        this.campaign = campaign;
    }

    public CustomersCampaigns() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
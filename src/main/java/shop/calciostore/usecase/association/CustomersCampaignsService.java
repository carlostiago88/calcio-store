package shop.calciostore.usecase.association;

import org.springframework.stereotype.Service;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.entities.Customer;
import shop.calciostore.persistence.entities.CustomersCampaigns;
import shop.calciostore.persistence.repositories.CampaignRepository;
import shop.calciostore.persistence.repositories.CustomerRepository;
import shop.calciostore.persistence.repositories.CustomersCampaignsRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CustomersCampaignsService {

    private CampaignRepository campaignRepository;
    private CustomerRepository customerRepository;
    private CustomersCampaignsRepository customersCampaignsRepository;

    public CustomersCampaignsService(CampaignRepository campaignRepository, CustomerRepository customerRepository, CustomersCampaignsRepository customersCampaignsRepository) {
        this.campaignRepository = campaignRepository;
        this.customerRepository = customerRepository;
        this.customersCampaignsRepository = customersCampaignsRepository;
    }

    public synchronized void campaignsAssociationFor(Customer customer) {
        Date today = Calendar.getInstance().getTime();
        List<Campaign> campaignsByTeam = campaignRepository.findAllByEndDateIsGreaterThanEqualAndSoccerTeamIdEquals(today, customer.getSoccerTeamId());
        if (campaignsByTeam.size() > 0) {
            campaignsByTeam.forEach(campaign -> match(customer, campaign));
        }
    }

    public synchronized void customersAssociationFor(Campaign campaign) {
        List<Customer> customersByTeam = customerRepository.findAllBySoccerTeamId(campaign.getSoccerTeamId());
        if (customersByTeam.size() > 0) {
            customersByTeam.forEach(customer -> match(customer, campaign));
        }
    }

    private synchronized void match(Customer customer, Campaign campaign) {
        if (!customersCampaignsRepository.existsAllByCampaign_IdAndCustomer_Id(campaign.getId(), customer.getId())) {
            CustomersCampaigns customersCampaigns = new CustomersCampaigns(customer, campaign);
            customersCampaignsRepository.save(customersCampaigns);
        }
    }
}
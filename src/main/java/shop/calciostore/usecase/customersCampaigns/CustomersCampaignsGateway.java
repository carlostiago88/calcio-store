package shop.calciostore.usecase.customersCampaigns;

import org.springframework.stereotype.Service;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.entities.Customer;
import shop.calciostore.persistence.entities.CustomersCampaigns;
import shop.calciostore.persistence.repositories.CampaignRepository;
import shop.calciostore.persistence.repositories.CustomersCampaignsRepository;

import java.util.List;

@Service
public class CustomersCampaignsGateway {

    private CampaignRepository campaignRepository;
    private CustomersCampaignsService customersCampaignsService;
    private CustomersCampaignsRepository customersCampaignsRepository;

    public CustomersCampaignsGateway(CampaignRepository campaignRepository, CustomersCampaignsService customersCampaignsService, CustomersCampaignsRepository customersCampaignsRepository) {
        this.campaignRepository = campaignRepository;
        this.customersCampaignsService = customersCampaignsService;
        this.customersCampaignsRepository = customersCampaignsRepository;
    }

    public List<CustomersCampaigns> findAllCampaignsByCustomerId(Long id){
        return customersCampaignsRepository.findAllByCustomer_Id(id);
    }

    public void matchCustomerCampaigns(Customer customer) {
        customersCampaignsService.campaignsAssociationFor(customer);
    }
    public void matchCampaignCustomers(Campaign campaign) {
        customersCampaignsService.customersAssociationFor(campaign);
    }
}


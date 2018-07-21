package shop.calciostore.usecase.campaign;

import org.javers.core.Javers;
import org.springframework.stereotype.Service;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;
import shop.calciostore.usecase.customersCampaigns.CustomersCampaignsGateway;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignGateway {

    private CampaignService campaignService;
    private CampaignRepository campaignRepository;
    private CustomersCampaignsGateway customersCampaignsGateway;
    private Javers javers;

    public CampaignGateway(CampaignService campaignService, CampaignRepository campaignRepository, CustomersCampaignsGateway customersCampaignsGateway, Javers javers) {
        this.campaignService = campaignService;
        this.campaignRepository = campaignRepository;
        this.customersCampaignsGateway = customersCampaignsGateway;
        this.javers = javers;
    }

    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }
    public Optional<Campaign> findOne(Long id) {
        return campaignRepository.findById(id);
    }

    public Campaign saveOrUpdate(Campaign campaign) {
        List<Campaign> campaignsSameEndDate = campaignRepository.findAllByEndDateEquals(campaign.getEndDate());
        if (campaignsSameEndDate.size() > 0) {
            campaignService.changeCampaignsWithSameEndDate(campaignsSameEndDate);
        }
        Campaign campaignCreated = campaignRepository.save(campaign);
        customersCampaignsGateway.matchCampaignCustomers(campaignCreated);
        javers.commit("user", campaignCreated);
        return campaignCreated;
    }

    public void deleteById(Campaign campaign){
        campaignRepository.deleteById(campaign.getId());
        javers.commit("user", campaign);
    }

}

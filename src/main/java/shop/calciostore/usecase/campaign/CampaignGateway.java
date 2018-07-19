package shop.calciostore.usecase.campaign;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.springframework.stereotype.Service;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignGateway {

    private CampaignService campaignService;
    private CampaignRepository campaignRepository;
    private Javers javers;

    public CampaignGateway(Javers javers,CampaignService campaignService, CampaignRepository campaignRepository) {
        this.campaignService = campaignService;
        this.campaignRepository = campaignRepository;
        this.javers = javers;
    }

    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    public Campaign saveOrUpdate(Campaign campaign) {
        List<Campaign> campaignsSameEndDate = campaignRepository.findAllByEndDateEquals(campaign.getEndDate());
        if (campaignsSameEndDate.size() > 0) {
            campaignService.changeCampaignsWithSameEndDate(campaignsSameEndDate);
        }
        Campaign campaignCreated = campaignRepository.save(campaign);
        javers.commit("user", campaignCreated);
        return campaignCreated;
    }

    public void deleteById(Campaign campaign){
        campaignRepository.deleteById(campaign.getId());
        javers.commit("user", campaign);
    }

}

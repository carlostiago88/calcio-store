package shop.calciostore.usecase.campaign;

import org.springframework.stereotype.Service;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;

import java.util.List;

@Service
public class CampaignGateway {

    private CampaignService campaignService;
    private CampaignRepository campaignRepository;

    public CampaignGateway(CampaignService campaignService, CampaignRepository campaignRepository) {
        this.campaignService = campaignService;
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    public Campaign saveOrUpdate(Campaign campaign) {
        List<Campaign> campaignsSameEndDate = campaignRepository.findAllByEndDateEquals(campaign.getEndDate());
        if (campaignsSameEndDate.size() == 0) {
            return campaignRepository.save(campaign);
        }
        campaignService.changeCampaignsWithSameEndDate(campaignsSameEndDate);
        return campaignRepository.save(campaign);
    }

}

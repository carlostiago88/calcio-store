package shop.calciostore.usecase.campaign;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignGateway {

    private CampaignService campaignService;
    private CampaignRepository campaignRepository;

    public CampaignGateway(CampaignService campaignService, CampaignRepository campaignRepository) {
        this.campaignService = campaignService;
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> findAll(){
         return campaignRepository.findAll();
    }

    public Campaign create(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public Campaign update(Long id,Campaign campaign){
        Optional<Campaign> exists = campaignRepository.findById(id);
        if(!exists.isPresent()){



        }

        return campaignRepository.save(campaign);
    }

}

package shop.calciostore.usecase.campaign;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;

import java.util.Date;
import java.util.List;

@Service
public class CampaignService {

    private CampaignRepository campaignRepository;

    public CampaignService() {
    }

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Transactional
    public synchronized void changeCampaignsWithSameEndDate(List<Campaign> campaignList) {
        campaignList.forEach(campaign ->
            campaignRepository.setEndDateFor(getNextFreeDate(campaign.getEndDate()), campaign.getId())
        );
    }

    private Date getNextFreeDate(Date date) {
        int i = 1;
        while (true) {
            Date nextFreeDate = DateUtils.addDays(date, i);
            if(campaignRepository.existsAllByEndDateEquals(nextFreeDate)){
                i++;
            }else{
                return nextFreeDate;
            }
        }
    }
}

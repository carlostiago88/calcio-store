package shop.calciostore.persistence;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;
import shop.calciostore.usecase.campaign.CampaignGateway;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CampaignTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CampaignRepository campaignRepository;

    private CampaignGateway campaignGateway;

    @Test
    public void shouldReturnTheSameCampaign(){
        //given
        Date date = Calendar.getInstance().getTime();
        Campaign excepted = new Campaign("Quarta Força",1L,date,date);
        entityManager.persist(excepted);
        entityManager.flush();
        //when
        Campaign actual = campaignRepository.findByName(excepted.getName()).get();
        //then
        assertThat(excepted.getName()).isEqualTo(actual.getName());
    }


}

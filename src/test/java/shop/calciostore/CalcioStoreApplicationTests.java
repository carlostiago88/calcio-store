package shop.calciostore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalcioStoreApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private CampaignRepository campaignRepository;

	@Test
	public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
		Campaign genericEntity = campaignRepository
				.save(new Campaign(1L));
		Optional<Campaign> foundEntity = campaignRepository
				.findOne(genericEntity.getId());

		assertNotNull(foundEntity);
		//assertEquals(genericEntity.getId(), foundEntity.get());
	}

}

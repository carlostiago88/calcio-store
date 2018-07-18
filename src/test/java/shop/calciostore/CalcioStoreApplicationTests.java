package shop.calciostore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date date = new Date();
		Campaign genericEntity = campaignRepository
				.save(new Campaign("Time do Povo",1L,date,date));
		Optional<Campaign> foundEntity = campaignRepository.findById(genericEntity.getId());

		assertNotNull(foundEntity);
	}

}

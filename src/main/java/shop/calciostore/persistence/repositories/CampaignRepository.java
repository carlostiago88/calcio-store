package shop.calciostore.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.calciostore.persistence.entities.Campaign;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Long>{

    List<Campaign> findAll();
    Optional<Campaign> findOne(@Param("id") Long id);
    Campaign save(Campaign campaign);


}

package shop.calciostore.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.calciostore.persistence.entities.Campaign;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Long>{

    List<Campaign> findAllByEndDateIsGreaterThanEqual(Date today);
    Optional<Campaign> findById(Long id);

}

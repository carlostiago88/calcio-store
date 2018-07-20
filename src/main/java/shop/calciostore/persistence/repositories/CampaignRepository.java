package shop.calciostore.persistence.repositories;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Repository;
import shop.calciostore.persistence.entities.Campaign;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@JaversSpringDataAuditable
public interface CampaignRepository extends JpaRepository<Campaign,Long>{

    @Modifying
    @Query("update Campaign c set c.endDate = ?1 where c.id = ?2")
    int setEndDateFor(Date newEndDate, Long id);
    List<Campaign> findAllByEndDateIsGreaterThanEqual(Date date);
    List<Campaign> findAllByEndDateEquals(@Temporal(TemporalType.DATE) Date date);
    Optional<Campaign> findById(Long id);
    Optional<Campaign> findByName(String name);
    Boolean existsAllByEndDateEquals(Date date);
    List<Campaign> findAllByEndDateIsGreaterThanEqualAndSoccerTeamIdEquals(Date date, Long id);

}

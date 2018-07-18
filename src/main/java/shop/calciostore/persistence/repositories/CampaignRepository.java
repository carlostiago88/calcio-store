package shop.calciostore.persistence.repositories;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
public interface CampaignRepository extends JpaRepository<Campaign,Long>{

    @Modifying
    @Query("update Campaign c set c.endDate = ?1 where c.id = ?2")
    int setEndDateFor(Date newEndDate, Long id);
    List<Campaign> findAllByEndDateIsGreaterThanEqual(Date date);
    List<Campaign> findAllByEndDateEquals(@Temporal(TemporalType.DATE) Date date);
    Optional<Campaign> findById(Long id);
    Boolean existsAllByEndDateEquals(Date date);

}

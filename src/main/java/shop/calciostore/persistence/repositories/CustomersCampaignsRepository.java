package shop.calciostore.persistence.repositories;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Repository;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.entities.CustomersCampaigns;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@JaversSpringDataAuditable
public interface CustomersCampaignsRepository extends JpaRepository<CustomersCampaigns,Long>{

   Boolean existsAllByCampaign_IdAndCustomer_Id(Long campaignId, Long customerId);
   List<CustomersCampaigns> findAllByCustomer_Id(Long customerId);
}

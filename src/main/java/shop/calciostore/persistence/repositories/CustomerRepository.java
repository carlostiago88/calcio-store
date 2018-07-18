package shop.calciostore.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.entities.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

    List<Customer> findAll();
    Optional<Customer> findById(@Param("id") Long id);


}

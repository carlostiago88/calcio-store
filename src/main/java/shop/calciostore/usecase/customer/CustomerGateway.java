package shop.calciostore.usecase.customer;

import org.javers.core.Javers;
import org.springframework.stereotype.Service;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.entities.Customer;
import shop.calciostore.persistence.repositories.CampaignRepository;
import shop.calciostore.persistence.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerGateway {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private Javers javers;

    public CustomerGateway(Javers javers, CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.javers = javers;
    }

    public List<Customer> findAll(){
         return customerRepository.findAll();
    }

    public Customer saveOrUpdate(Customer customer) {
        Customer customerCreated = customerRepository.save(customer);
        javers.commit("user", customerCreated);
        return customerCreated;
    }
}

package shop.calciostore.usecase.customer;

import org.javers.core.Javers;
import org.springframework.stereotype.Service;
import shop.calciostore.persistence.entities.Customer;
import shop.calciostore.persistence.repositories.CustomerRepository;
import shop.calciostore.usecase.association.CustomersCampaignsGateway;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerGateway {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private CustomersCampaignsGateway customersCampaignsGateway;
    private Javers javers;

    public CustomerGateway(CustomerService customerService, CustomerRepository customerRepository, CustomersCampaignsGateway customersCampaignsGateway, Javers javers) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.customersCampaignsGateway = customersCampaignsGateway;
        this.javers = javers;
    }

    public List<Customer> findAll(){
         return customerRepository.findAll();
    }
    public Optional<?> findOne(Long id){
         return customerRepository.findById(id);
    }

    public Customer saveOrUpdate(Customer customer) {
        Customer customerCreated = customerRepository.save(customer);
        customersCampaignsGateway.matchCustomerCampaigns(customerCreated);
        javers.commit("user", customerCreated);
        return customerCreated;
    }
}

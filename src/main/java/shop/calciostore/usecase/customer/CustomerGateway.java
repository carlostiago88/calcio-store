package shop.calciostore.usecase.customer;

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

    public CustomerGateway(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
         return customerRepository.findAll();
    }
}

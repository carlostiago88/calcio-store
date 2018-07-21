package shop.calciostore.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.calciostore.persistence.entities.Customer;
import shop.calciostore.persistence.repositories.CustomerRepository;
import shop.calciostore.usecase.customersCampaigns.CustomersCampaignsGateway;
import shop.calciostore.usecase.customer.CustomerGateway;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private CustomerGateway customerGateway;
    private CustomersCampaignsGateway customersCampaignsGateway;
    private CustomerRepository customerRepository;

    public CustomerController(CustomerGateway customerGateway, CustomersCampaignsGateway customersCampaignsGateway, CustomerRepository customerRepository) {
        this.customerGateway = customerGateway;
        this.customersCampaignsGateway = customersCampaignsGateway;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/v1")
    @ResponseBody
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(customerGateway.findAll(),HttpStatus.OK);
    }
    @GetMapping("/v1/{id}")
    @ResponseBody
    public ResponseEntity<Object> findOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(customerGateway.findOne(id),HttpStatus.OK);
    }

    @PostMapping("/v1/create")
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody Customer customer){
        return new ResponseEntity<>(customerGateway.saveOrUpdate(customer),HttpStatus.CREATED);
    }

    @GetMapping("/v1/{id}/campaigns")
    @ResponseBody
    public ResponseEntity<Object> findAllCampaignsById(@PathVariable("id") Long id){
        return new ResponseEntity<>(customersCampaignsGateway.findAllCampaignsByCustomerId(id),HttpStatus.OK);
    }

    @PutMapping(path = "/v1/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Customer customer){
        Optional<Customer> exists = customerRepository.findById(id);
        if(!exists.isPresent()){
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        return new ResponseEntity<>(customerGateway.saveOrUpdate(customer),HttpStatus.OK);
    }

    @DeleteMapping(path = "/v1/delete", value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
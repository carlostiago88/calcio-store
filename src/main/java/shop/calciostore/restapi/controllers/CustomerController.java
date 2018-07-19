package shop.calciostore.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.calciostore.persistence.entities.Customer;
import shop.calciostore.usecase.customer.CustomerGateway;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private CustomerGateway customerGateway;

    public CustomerController(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @GetMapping("/v1")
    public List<Customer> findAll(){
        return customerGateway.findAll();
    }

    @PostMapping("/v1/create")
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody Customer customer){
        return new ResponseEntity<>(customerGateway.saveOrUpdate(customer),HttpStatus.CREATED);
    }
/*
    @PutMapping(path = "/v1/update",value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Customer customer){

    }

    @DeleteMapping(path = "/v1/delete", value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){

    }
*/
}
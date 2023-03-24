package edu.iu.p565.customerservice.controller;

import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.customerservice.repository.CustomerRepository;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public int create(@Valid @RequestBody Customer customer) {
        return repository.create(customer);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id) {
        repository.update(customer, id);
        System.out.println("Customer Updated Successfully...");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repository.delete(id);
        System.out.println("Customer deleted Successfully...");
    }
}

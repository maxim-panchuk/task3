package diasoft.mpanchuk.task3.controller;

import diasoft.mpanchuk.task3.entity.Customer;
import diasoft.mpanchuk.task3.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    private final CustomerService customerService;

    @Autowired
    public Controller(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public Customer getOne(@PathVariable Long id) {
        Optional<Customer> op = customerService.getCustomerById(id);
        return op.orElse(null);
    }

    @PutMapping("/put")
    public Customer updateOne(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        logger.info("Got customer" + customer.toString());
        return  customerService.createCustomer(customer);
    }
}

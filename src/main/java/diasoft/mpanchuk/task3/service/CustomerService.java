package diasoft.mpanchuk.task3.service;

import diasoft.mpanchuk.task3.entity.Customer;
import diasoft.mpanchuk.task3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}

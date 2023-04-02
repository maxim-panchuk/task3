package diasoft.mpanchuk.task3.service;


import diasoft.mpanchuk.task3.controller.Controller;
import diasoft.mpanchuk.task3.entity.Customer;
import diasoft.mpanchuk.task3.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тест Service")
public class ServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    @DisplayName("Создание Customer")
    public void testCreate() {
        Customer customer = new Customer();
        customer.setFirstName("Panchuk");

        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
        Customer actual = customerService.createCustomer(customer);

        Mockito.verify(customerRepository, times(1)).save(customer);
        Assertions.assertEquals(actual, customer);
    }

    @Test
    @DisplayName("Возврат списка Customer")
    public void testGetAll() {
        Customer customer = new Customer();
        Customer customer1 = new Customer();
        customer1.setFirstName("panchuk");
        customer.setFirstName("obramov");

        List<Customer> list = new ArrayList<>();
        list.add(customer1);
        list.add(customer);

        Mockito.when(customerRepository.findAll()).thenReturn(list);
        List<Customer> actualList = customerService.getAllCustomers();
        Assertions.assertEquals(list, actualList);
    }

    @Test
    @DisplayName("Возврат Customer по ID")
    public void testGetOne() {
        Customer customer = new Customer();
        customer.setId(1L);

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Optional<Customer> actual = customerService.getCustomerById(1L);
        Assertions.assertEquals(actual.get(), customer);
    }
}

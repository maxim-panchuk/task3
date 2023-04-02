package diasoft.mpanchuk.task3.controller;

import diasoft.mpanchuk.task3.entity.Customer;
import org.junit.jupiter.api.Assertions;
import diasoft.mpanchuk.task3.service.CustomerService;
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
@DisplayName("Тест Controller-а")
public class ControllerTest {
    @Mock
    private CustomerService customerService;

    @InjectMocks
    private Controller controller;

    @Test
    @DisplayName("Создание Customer")
    public void testCreate() {
        Customer customer = new Customer();
        customer.setFirstName("Panchuk");

        Mockito.when(customerService.createCustomer(customer)).thenReturn(customer);
        Customer actual = controller.create(customer);

        Mockito.verify(customerService, times(1)).createCustomer(customer);
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

        Mockito.when(customerService.getAllCustomers()).thenReturn(list);
        List<Customer> actualList = controller.getAll();
        Assertions.assertEquals(list, actualList);
    }

    @Test
    @DisplayName("Возврат Customer по ID")
    public void testGetOne() {
        Customer customer = new Customer();
        customer.setId(1L);

        Mockito.when(customerService.getCustomerById(1L)).thenReturn(Optional.of(customer));
        Customer actual = controller.getOne(1L);
        Assertions.assertEquals(actual, customer);
    }
}

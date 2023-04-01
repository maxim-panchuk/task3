package diasoft.mpanchuk.task3.repository;

import diasoft.mpanchuk.task3.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

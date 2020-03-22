package se.ecutb.cheng.exercises.data;

import se.ecutb.cheng.exercises.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    Customer save(Customer customer);

    Optional<Customer> findById(String customerId);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByDetailsId(String detailsId);

    Optional<Customer> findByCity(String city);

    List<Customer> findAll();

    boolean delete(String customerId);

    Customer update(Customer updatedCustomer);
}

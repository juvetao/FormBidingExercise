package se.ecutb.cheng.exercises.data;

import org.springframework.stereotype.Component;
import se.ecutb.cheng.exercises.entity.Customer;
import se.ecutb.cheng.exercises.entity.CustomerDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoInMemory implements CustomerDao{
    private List<Customer> customerList = new ArrayList<>();

    @Override
    public Customer save(final Customer customer){
        if(customerList.contains(customer)){
            throw new IllegalArgumentException();
        }
        customerList.add(customer);
        return findById(customer.getCustomerId()).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Optional<Customer> findById(final String customerId){
        return customerList.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst();
    }

    @Override
    public Optional<Customer> findByEmail(final String email){
        return customerList.stream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Optional<Customer> findByDetailsId(final String detailsId){
        return customerList.stream()
                .filter(customer -> customer.getCustomerDetails().getDetailsId().equals(detailsId))
                .findFirst();
    }

    @Override
    public Optional<Customer> findByCity(final String city){
        return customerList.stream()
                .filter(customer -> customer.getCustomerDetails().getCity().equalsIgnoreCase(city))
                .findFirst();
    }

    @Override
    public List<Customer> findAll(){
        return Collections.unmodifiableList(customerList);
    }

    @Override
    public boolean delete(final String customerId){
        Optional<Customer> optional = findById(customerId);
        if(optional.isPresent()){
            return customerList.remove(optional.get());
        }
        return false;
    }

    @Override
    public Customer update(final Customer updatedCustomer){
        Customer original = findById(updatedCustomer.getCustomerId()).orElseThrow(IllegalArgumentException::new);
        original.setEmail(updatedCustomer.getEmail());
        original.setRegDate(updatedCustomer.getRegDate());
        original.setActive(updatedCustomer.isActive());
        original.setCustomerDetails( new CustomerDetails(updatedCustomer.getCustomerDetails().getStreet(),
                                    updatedCustomer.getCustomerDetails().getZipCode(),
                                    updatedCustomer.getCustomerDetails().getCity(),
                                    updatedCustomer.getCustomerDetails().getHomePhone(),
                                    updatedCustomer.getCustomerDetails().getCellPhone()));
        return original;
    }
}

package se.ecutb.cheng.exercises.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Customer {
    private String customerId;
    private String email;
    private LocalDate regDate;
    private boolean active;
    private CustomerDetails customerDetails;

    public Customer(String email, CustomerDetails customerDetails) {
        customerId = UUID.randomUUID().toString();
        this.email = email;
        this.regDate = LocalDate.now();
        this.active = true;
        this.customerDetails = customerDetails;
    }

    public Customer(){}

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return active == customer.active &&
                Objects.equals(customerId, customer.customerId) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(regDate, customer.regDate) &&
                Objects.equals(customerDetails, customer.customerDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, regDate, active, customerDetails);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("customerId='").append(customerId).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", regDate=").append(regDate);
        sb.append(", active=").append(active);
        sb.append(", customerDetails=").append(customerDetails);
        sb.append('}');
        return sb.toString();
    }
}

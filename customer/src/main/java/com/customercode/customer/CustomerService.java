package com.customercode.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistartionRequest customerRequest) {
        Customer customer= Customer.builder()
                        .firstName(customerRequest.firstName())
                        .lastName(customerRequest.lastName())
                        .email(customerRequest.email())
                        .build();
                        
                        customerRepository.saveAndFlush(customer);
                        FraudCheckResposne fraudCheckResposne=restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",
                        FraudCheckResposne.class,
                        customer.getId()
                        );

                        if(fraudCheckResposne.isFraudCustomer())
                        {
                            throw new IllegalStateException("Fradulant customer");
                        }
    }
    
}

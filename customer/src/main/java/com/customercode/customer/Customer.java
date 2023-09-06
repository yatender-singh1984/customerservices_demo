package com.customercode.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @SequenceGenerator(
        name="customer_id_sequence",
        sequenceName="customer_id_sequence")
    @GeneratedValue(
        generator = "customer_id_sequence",
        strategy = GenerationType.SEQUENCE)
    public Integer Id;
    public String firstName;
    public String lastName;
    public String email;
    
}

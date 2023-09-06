package com.customer.fraud;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
   
    public boolean isFradulantCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
            .customerId(customerId)
            .isFraudster(false)
            .createdAt(LocalDate.now())
            .build()
        );
        return false;
    }
    
}

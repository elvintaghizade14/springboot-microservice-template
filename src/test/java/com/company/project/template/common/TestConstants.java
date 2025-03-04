package com.company.project.template.common;


import static com.company.project.common.model.constant.CommonConstants.HttpHeader.PN_CUSTOMER_ID;
import static com.company.project.common.model.constant.CommonConstants.HttpHeader.PN_LANGUAGE;

import com.company.project.common.messaging.BaseResultEvent;
import com.company.project.common.messaging.Result;
import com.company.project.template.dao.entity.AccountEntity;
import com.company.project.template.model.dto.AccountDto;
import com.company.project.template.model.dto.PaymentDto;
import com.company.project.template.model.dto.PaymentResponseDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public interface TestConstants {

    String BASE_PATH = "/template-project";
    Long ID = 1L;
    String TRACE_ID = "d19651710515fd53dde625f6d0443cef";
    Map<String, String> PN_HEADERS = Map.of(PN_LANGUAGE, "en");

    static AccountDto accountDto() {
        return AccountDto.builder()
                .id(1L)
                .customerId("111")
                .accountNumber("123456789")
                .accountHolderName("John Doe")
                .accountType("SAVING")
                .balance(BigDecimal.ZERO)
                .currency("USD")
                .build();
    }

    static AccountDto createAccountDto() {
        return AccountDto.builder()
                .customerId("111")
                .accountNumber("123456789")
                .accountHolderName("John Doe")
                .accountType("SAVING")
                .balance(BigDecimal.ZERO)
                .currency("USD")
                .build();
    }

    static AccountDto createAccountDtoWithWrongHolderName() {
        return AccountDto.builder()
                .customerId("111")
                .accountNumber("123456789")
                .accountHolderName("John Doe 07")
                .accountType("SAVING")
                .balance(BigDecimal.ZERO)
                .currency("USD")
                .build();
    }

    static AccountDto updateAccountDto() {
        return AccountDto.builder()
                .id(ID)
                .customerId("111")
                .accountNumber("123456789")
                .accountHolderName("John Doe")
                .accountType("SAVING")
                .balance(BigDecimal.ZERO)
                .currency("USD")
                .build();
    }

    static AccountEntity accountEntity() {
        return AccountEntity.builder()
                .id(1L)
                .customerId("111")
                .accountNumber("123456789")
                .accountHolderName("John Doe")
                .accountType("SAVING")
                .balance(BigDecimal.ZERO)
                .currency("USD")
                .build();
    }

    static PaymentDto paymentDto() {
        return PaymentDto.builder()
                .paymentId("PAY-1001")
                .accountNumber("123456789")
                .amount(BigDecimal.valueOf(150.75))
                .currency("USD")
                .paymentMethod("Credit Card")
                .recipientName("John Doe")
                .recipientAccountNumber("987654321")
                .additionalData(Map.of("note", "Subscription payment"))
                .build();
    }

    static PaymentResponseDto paymentResponseDto() {
        return PaymentResponseDto.builder()
                .paymentExecutionId(UUID.randomUUID().toString())
                .expireAt(LocalDateTime.now().plusMinutes(5))
                .build();
    }

    static BaseResultEvent<PaymentDto> paymentDtoBaseResultEvent() {
        return BaseResultEvent.<PaymentDto>builder()
                .eventId(UUID.randomUUID().toString())
                .headers(Map.of(PN_CUSTOMER_ID, "111"))
                .result(Result.SUCCESS)
                .payload(paymentDto())
                .build();
    }

}

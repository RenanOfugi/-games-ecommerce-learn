package com.ecommerce.games.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutEntityToPaymentDTO {

    private Long id;

    @NotEmpty
    private String code;

    @NotEmpty
    private String value;
}

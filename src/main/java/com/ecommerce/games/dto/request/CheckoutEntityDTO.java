package com.ecommerce.games.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutEntityDTO {

    private Long id;

    private String code;

    private String firstName;
}

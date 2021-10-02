package com.ecommerce.games.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutEntityDTO {

    private Long id;

    @NotEmpty
    private String code;

    @NotEmpty
    private String firstName;
}

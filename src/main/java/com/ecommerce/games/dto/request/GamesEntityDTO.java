package com.ecommerce.games.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GamesEntityDTO {

    private Long id;

    @NotEmpty
    private String nameGame;

    @NotEmpty
    private String value;
}

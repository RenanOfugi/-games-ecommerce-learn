package com.ecommerce.games.request;

import com.ecommerce.games.dto.request.GamesEntityDTO;
import com.ecommerce.games.entity.GamesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutGamesRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private List<GamesEntityDTO> games;
    private String value;
}

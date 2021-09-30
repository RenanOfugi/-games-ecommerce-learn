package com.ecommerce.games.service;

import com.ecommerce.games.dto.request.CheckoutEntityDTO;
import com.ecommerce.games.dto.response.MessageResponseDTO;
import com.ecommerce.games.entity.CheckoutEntity;
import com.ecommerce.games.mapper.CheckoutGamesMapper;
import com.ecommerce.games.repository.CheckoutGamesRepository;
import com.ecommerce.games.request.CheckoutGamesRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutGamesService {

    private final CheckoutGamesRepository repository;
    private final CheckoutGamesMapper mapper = CheckoutGamesMapper.INSTANCE;

    public MessageResponseDTO create(CheckoutGamesRequest request){

        CheckoutEntityDTO entityDTO = CheckoutEntityDTO.builder()
                .code(UUID.randomUUID().toString())
                .firstName(request.getFirstName())
                .build();

        CheckoutEntity checkout = mapper.toModel(entityDTO);

        /* inserir no BD*/

        return MessageResponseDTO.builder()
                .message("Checkout realizado com sucesso!")
                .code(checkout.getCode())
                .build();
    }
}

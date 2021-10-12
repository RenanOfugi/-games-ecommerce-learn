package com.ecommerce.games.service;

import com.ecommerce.games.dto.request.CheckoutEntityDTO;
import com.ecommerce.games.dto.response.MessageResponseDTO;
import com.ecommerce.games.entity.CheckoutEntity;
import com.ecommerce.games.mapper.CheckoutEntityMapper;
import com.ecommerce.games.repository.CheckoutGamesRepository;
import com.ecommerce.games.request.CheckoutGamesRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutGamesService {

    @Autowired
    private final CheckoutGamesRepository repository;
    private final CheckoutEntityMapper mapper = CheckoutEntityMapper.INSTANCE;

    private final KafkaTemplate<Object,Object> template;

    public MessageResponseDTO create(CheckoutGamesRequest gamesRequest){

        CheckoutEntityDTO entityGamesDTO = CheckoutEntityDTO.builder()
                .code(UUID.randomUUID().toString())
                .firstName(gamesRequest.getFirstName())
                .lastName(gamesRequest.getLastName())
                .email(gamesRequest.getEmail())
                .games(gamesRequest.getGames())
                .value(gamesRequest.getValue())
                .build();

        CheckoutEntity entityGames = mapper.toModel(entityGamesDTO);

        repository.save(entityGames);

        return MessageResponseDTO.builder()
                .message("Checkout realizado com sucesso!")
                .code(entityGames.getCode())
                .build();
    }

    public <T> void addEventKafka(String topic, T data){
        template.send(topic,data);
    }
}

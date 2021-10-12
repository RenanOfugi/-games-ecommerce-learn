package com.ecommerce.games.controller;

import com.ecommerce.games.dto.request.CheckoutEntityDTO;
import com.ecommerce.games.dto.request.GamesEntityDTO;
import com.ecommerce.games.dto.response.MessageResponseDTO;
import com.ecommerce.games.request.CheckoutGamesRequest;
import com.ecommerce.games.service.CheckoutGamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/games-checkout")
@RequiredArgsConstructor
public class GamesCheckoutController {

    @Autowired
    private final CheckoutGamesService service;

    @PostMapping()
    public ResponseEntity<MessageResponseDTO> create (@RequestBody CheckoutGamesRequest request){
        final MessageResponseDTO responseDTO = service.create(request);
        CheckoutEntityDTO paymentDto = criarDto(responseDTO.getCode(), request.getValue());
        service.addEventKafka("SalvaCheckout", paymentDto);
        return ResponseEntity.ok().body(responseDTO);
    }

    private CheckoutEntityDTO criarDto(String code, String valor){
        return CheckoutEntityDTO.builder()
                .code(code)
                .value(valor)
                .build();
    }
}

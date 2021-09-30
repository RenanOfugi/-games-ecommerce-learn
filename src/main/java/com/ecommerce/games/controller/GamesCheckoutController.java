package com.ecommerce.games.controller;

import com.ecommerce.games.dto.response.MessageResponseDTO;
import com.ecommerce.games.request.CheckoutGamesRequest;
import com.ecommerce.games.service.CheckoutGamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/games-checkout")
@RequiredArgsConstructor
public class GamesCheckoutController {

    private final CheckoutGamesService service;

    @PostMapping("/")
    public ResponseEntity<MessageResponseDTO> create (@RequestBody CheckoutGamesRequest request){
        final MessageResponseDTO responseDTO = service.create(request);
        service.addEventKafka("SalvaCheckout", request);
        return ResponseEntity.ok().body(responseDTO);
    }
}

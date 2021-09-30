package com.ecommerce.games.mapper;

import com.ecommerce.games.dto.request.CheckoutEntityDTO;
import com.ecommerce.games.entity.CheckoutEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CheckoutGamesMapper {
    CheckoutGamesMapper INSTANCE = Mappers.getMapper(CheckoutGamesMapper.class);
    CheckoutEntity toModel(CheckoutEntityDTO entityDTO);
}

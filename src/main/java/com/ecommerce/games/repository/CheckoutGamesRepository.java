package com.ecommerce.games.repository;

import com.ecommerce.games.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutGamesRepository extends JpaRepository<CheckoutEntity, Long> {
}

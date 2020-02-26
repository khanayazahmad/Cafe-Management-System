package com.cmpe202.starbucks.repository;

import com.cmpe202.starbucks.model.User;
import org.springframework.data.repository.CrudRepository;
import com.cmpe202.starbucks.model.Card;

import java.util.List;
import java.util.Optional;

public interface ICardRepository  extends CrudRepository<Card, String> {

    Optional<Card> findCardByCardNumberAndCardCodeAndUser(String cardNumber, String cardCode, User user);

    List<Card> findByUser(User user);

}

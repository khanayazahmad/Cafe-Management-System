package com.cmpe202.starbucks.service;

import com.cmpe202.starbucks.dto.NewCardDto;
import com.cmpe202.starbucks.dto.OrderDto;
import com.cmpe202.starbucks.model.Card;
import com.cmpe202.starbucks.model.Menu;
import com.cmpe202.starbucks.model.User;
import com.cmpe202.starbucks.repository.ICardRepository;
import com.cmpe202.starbucks.repository.IMenuRepository;
import com.cmpe202.starbucks.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {


    private final OrderService orderService;
    private final ICardRepository cardRepository;
    private final IUserRepository userRepository;
    private final IMenuRepository menuRepository;

    @Autowired
    public PaymentService(OrderService orderService, ICardRepository cardRepository,
                          IUserRepository userRepository, IMenuRepository menuRepository) {
        this.orderService = orderService;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
    }

    public ResponseEntity<String> orderPayment(NewCardDto newCardDto, OrderDto orderDto){

        Optional<User> userFound = userRepository.findById(newCardDto.getUser().getId());
        if(!userFound.isPresent()){
            return new ResponseEntity<>("Wrong User",
                    HttpStatus.BAD_REQUEST);
        }
        User user = userFound.get();

        Optional<Card> cardFound = cardRepository.findCardByCardNumberAndCardCodeAndUser(newCardDto.getCardNumber(),newCardDto.getCardCode(),user);
        Card card = new Card();
        if(cardFound.isPresent()){

            cardFound.ifPresent(result->{
                card.setCardNumber(result.getCardNumber());
                card.setCardCode(result.getCardCode());
                card.setBalance(result.getBalance());
                card.setUser(result.getUser());
            });

            if(orderDto.getTotalPrice() <= card.getBalance()
                    && orderDto.getUser().getId().equals(user.getId())){
                orderDto.setUser(user);
                List<Menu> list = orderDto.getMenuItems();
                List<Menu> opList = new ArrayList<>();
                list.forEach(item->{
                    opList.add(menuRepository.findById(item.getId()));
                });
                orderDto.setMenuItems(opList);
                card.setBalance(card.getBalance() - orderDto.getTotalPrice());
                cardRepository.save(card);
                orderService.addOrder(orderDto);
                return ResponseEntity.ok("Payment Successful");

            }else{

                return new ResponseEntity<>("Insufficient Balance",
                        HttpStatus.BAD_REQUEST);
            }

        }else{
            return new ResponseEntity<>("Wrong Card Code",
                    HttpStatus.BAD_REQUEST);
        }


    }



}

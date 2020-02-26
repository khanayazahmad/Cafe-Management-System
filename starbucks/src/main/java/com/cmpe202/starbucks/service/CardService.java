package com.cmpe202.starbucks.service;

import com.cmpe202.starbucks.dto.AddCardResponseDto;
import com.cmpe202.starbucks.dto.CardDetailsDto;
import com.cmpe202.starbucks.dto.SelectedCardDto;
import com.cmpe202.starbucks.dto.NewCardDto;
import com.cmpe202.starbucks.model.Card;
import com.cmpe202.starbucks.model.User;
import com.cmpe202.starbucks.repository.ICardRepository;
import com.cmpe202.starbucks.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CardService {

    private final ICardRepository cardRepository;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CardService(ICardRepository cardRepository, IUserRepository userRepository){
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<AddCardResponseDto> addCard(NewCardDto newCardDto){

        Card newCard = modelMapper.map(newCardDto, Card.class);

        if(null != cardRepository.save(newCard)){
            return ResponseEntity.ok(new AddCardResponseDto(true, newCard.getCardNumber()));

        }else{
            return new ResponseEntity<AddCardResponseDto>(new AddCardResponseDto(false, ""), HttpStatus.BAD_REQUEST);

        }

    }

    public ResponseEntity<String> selectCard(NewCardDto newCardDto){

        Optional<Card>  cardFound = cardRepository.findCardByCardNumberAndCardCodeAndUser(newCardDto.getCardNumber(),
                newCardDto.getCardCode(), newCardDto.getUser());
        SelectedCardDto selectedCardDto = SelectedCardDto.getInstance();
        cardFound.ifPresent(result-> {
            selectedCardDto.setBalance(result.getBalance());
            selectedCardDto.setCardNumber(result.getCardNumber());
            selectedCardDto.setCardCode(result.getCardCode());
            selectedCardDto.setUser(result.getUser());
        });

        if(cardFound.isPresent()){
            return ResponseEntity.ok("Card found, verified and selected");

        }else{
            return new ResponseEntity<>("Card with number: " + newCardDto.getCardNumber()+" does not exist",
                    HttpStatus.BAD_REQUEST);

        }

    }

    public ResponseEntity<String> unSelectCard(NewCardDto newCardDto){

        SelectedCardDto selectedCardDto = SelectedCardDto.getInstance();

        if(selectedCardDto.getCardNumber().equals(newCardDto.getCardNumber()) &&
            selectedCardDto.getCardCode().equals(newCardDto.getCardCode())){

            selectedCardDto.resetCard();

            return ResponseEntity.ok("Card reset");

        }else{
            return new ResponseEntity<>("Card with number: " + newCardDto.getCardNumber()+" does not exist",
                    HttpStatus.BAD_REQUEST);

        }

    }

    public List<CardDetailsDto> getAllCardsByUserId(Long userId){

        Optional<User> userFound = userRepository.findById(userId);
        User user = new User();
        List<CardDetailsDto> cardDetailsDtoList = new ArrayList<>();

        userFound.ifPresent(result->{
            user.setId(result.getId());
            user.setFirstname(result.getFirstname());
        });

        if(userFound.isPresent()){
            List<Card> cardsFound = cardRepository.findByUser(user);
            cardsFound.forEach(card->{
                card.setUser(user);
                cardDetailsDtoList.add(modelMapper.map(card,CardDetailsDto.class));
            });
        }

        return cardDetailsDtoList;


    }

}

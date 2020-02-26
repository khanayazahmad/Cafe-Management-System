package com.cmpe202.starbucks.controller;

import com.cmpe202.starbucks.dto.AddCardResponseDto;
import com.cmpe202.starbucks.dto.CardDetailsDto;
import com.cmpe202.starbucks.dto.NewCardDto;
import com.cmpe202.starbucks.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/card")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    ResponseEntity<AddCardResponseDto> addCard(@RequestBody NewCardDto newCardDto){

        return cardService.addCard(newCardDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/select")
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    ResponseEntity<String> selectCard(@RequestBody NewCardDto newCardDto){

        return cardService.selectCard(newCardDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/unselect")
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    ResponseEntity<String> unSelectCard(@RequestBody NewCardDto newCardDto){

        return cardService.unSelectCard(newCardDto);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/get/byUserId/{userId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    List<CardDetailsDto> getAllCardsByUserId(@PathVariable(value = "userId") Long userId){

        return cardService.getAllCardsByUserId(userId);
    }
}

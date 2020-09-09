package com.example.demo.service.impl;

import com.example.demo.entity.Card;
import com.example.demo.repository.CardRepository;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getCardList() {
        return cardRepository.findAll();
    }

    @Override
    public Card findCardById(long id) {
        return cardRepository.findById(id);
    }
}

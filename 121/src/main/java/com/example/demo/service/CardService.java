package com.example.demo.service;

import com.example.demo.entity.Card;
import java.util.List;

public interface CardService {
    public List<Card> getCardList();
    public Card findCardById(long id);
}
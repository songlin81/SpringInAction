package com.example.demo.repository;

import com.example.demo.entity.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class CardRepositoryTest {

    @Autowired
    private CardRepository  cardRepository;

    @Test
    public void testQuery() {
        List<Card> list = cardRepository.findAll();
        for (Card card : list) {
            System.out.println(card);
        }
    }

    @Test
    public void testRollBank() {
        Card card=new Card();
        card.setNum(3);
        cardRepository.save(card);
    }
}
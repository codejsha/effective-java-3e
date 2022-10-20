package org.example.demo.chapter2.item2.hierarchicalbuilder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.example.demo.chapter2.item2.hierarchicalbuilder.NyPizza.Size.SMALL;
import static org.example.demo.chapter2.item2.hierarchicalbuilder.Pizza.Topping.ONION;
import static org.example.demo.chapter2.item2.hierarchicalbuilder.Pizza.Topping.SAUSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
class NyPizzaTest {
    @Test
    void testNyPizza(){
        var itemMock = mock(NyPizza.class);
        when(itemMock.getToppings()).thenReturn(new HashSet<>(){
            {
                add(SAUSAGE);
                add(ONION);
            }
        });
        when(itemMock.getSize()).thenReturn(SMALL);

        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        assertEquals(itemMock.getToppings(), pizza.getToppings());
        assertEquals(itemMock.getSize(), pizza.getSize());
    }
}

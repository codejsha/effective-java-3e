package org.example.demo.chapter2.item2.hierarchicalbuilder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.example.demo.chapter2.item2.hierarchicalbuilder.Pizza.Topping.HAM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
class CalzoneTest {
    @Test
    void testCalzone() {
        var itemMock = mock(Calzone.class);
        when(itemMock.getToppings()).thenReturn(new HashSet<>() {
            {
                add(HAM);
            }
        });
        when(itemMock.isSauceInside()).thenReturn(true);

        var calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();

        assertEquals(itemMock.getToppings(), calzone.getToppings());
        assertEquals(itemMock.isSauceInside(), calzone.isSauceInside());
    }
}

package org.example.demo.chapter2.item2.javabeans;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
class NutritionFactsTest {
    @Test
    void testJavaBean(){
        var itemMock  = mock(NutritionFacts.class);
        when(itemMock.getServingSize()).thenReturn(240);
        when(itemMock.getServings()).thenReturn(8);
        when(itemMock.getCalories()).thenReturn(100);
        when(itemMock.getFat()).thenReturn(0);
        when(itemMock.getSodium()).thenReturn(35);
        when(itemMock.getCarbohydrate()).thenReturn(27);

        var cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);

        assertEquals(itemMock.getServingSize(), cocaCola.getServingSize());
        assertEquals(itemMock.getServings(), cocaCola.getServings());
        assertEquals(itemMock.getCalories(), cocaCola.getCalories());
        assertEquals(itemMock.getFat(), cocaCola.getFat());
        assertEquals(itemMock.getSodium(), cocaCola.getSodium());
        assertEquals(itemMock.getCarbohydrate(), cocaCola.getCarbohydrate());
    }
}

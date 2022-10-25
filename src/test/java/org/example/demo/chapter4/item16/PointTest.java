package org.example.demo.chapter4.item16;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class PointTest {
    @Test
    void testPoint(){
        var itemMock = spy(new Point(1.0, 2.0));

        assertEquals(1.0, itemMock.getX());
        assertEquals(2.0, itemMock.getY());
        verify(itemMock, times(1)).getX();
        verify(itemMock, times(1)).getY();

        itemMock.setX(3.0);
        itemMock.setY(4.0);
        verify(itemMock, times(1)).setX(3.0);
        verify(itemMock, times(1)).setY(4.0);

        assertEquals(3.0, itemMock.getX());
        assertEquals(4.0, itemMock.getY());
        verify(itemMock, times(2)).getX();
        verify(itemMock, times(2)).getY();
    }
}

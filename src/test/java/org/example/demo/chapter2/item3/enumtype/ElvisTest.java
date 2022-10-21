package org.example.demo.chapter2.item3.enumtype;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ElvisTest {
    @Test
    void testEnumType() {
        var itemMock = spy(Elvis.INSTANCE);
        assertEquals(itemMock.getClass(), Elvis.INSTANCE.getClass());

        itemMock.leaveTheBuilding();
        verify(itemMock, times(1)).leaveTheBuilding();
    }
}

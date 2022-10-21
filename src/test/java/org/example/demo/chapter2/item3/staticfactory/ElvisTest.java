package org.example.demo.chapter2.item3.staticfactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ElvisTest {
    @Test
    void testStaticFactory() {
        var itemMock = spy(Elvis.class);
        assertEquals(itemMock.getClass(), Elvis.getInstance().getClass());

        itemMock.leaveTheBuilding();
        verify(itemMock, times(1)).leaveTheBuilding();
    }
}

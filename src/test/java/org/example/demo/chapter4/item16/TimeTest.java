package org.example.demo.chapter4.item16;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
@Slf4j
class TimeTest {
    @Test
    void testTime() {
        var itemMock = spy(new Time(10, 42));
        assertEquals(10, itemMock.hour);
        assertEquals(42, itemMock.minute);

        assertThrows(IllegalArgumentException.class, () -> new Time(24, 42));
        assertThrows(IllegalArgumentException.class, () -> new Time(10, 60));
        assertThrows(IllegalArgumentException.class, () -> new Time(24, 60));
        assertThrows(IllegalArgumentException.class, () -> new Time(-1, 42));
        assertThrows(IllegalArgumentException.class, () -> new Time(10, -1));
    }
}

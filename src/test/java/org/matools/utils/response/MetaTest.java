package org.matools.utils.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetaTest {

    @Test
    void shouldBuildMetaCorrectly() {
        Meta meta = Meta.builder()
                .page(1)
                .size(10)
                .totalElements(100L)
                .totalPages(10)
                .hasNext(true)
                .hasPrevious(false)
                .build();

        assertEquals(1, meta.getPage());
        assertEquals(10, meta.getSize());
        assertEquals(100L, meta.getTotalElements());
        assertEquals(10, meta.getTotalPages());
        assertTrue(meta.getHasNext());
        assertFalse(meta.getHasPrevious());
    }

    @Test
    void shouldAllowNullValues() {
        Meta meta = Meta.builder().build();

        assertNull(meta.getPage());
        assertNull(meta.getSize());
        assertNull(meta.getTotalElements());
        assertNull(meta.getTotalPages());
        assertNull(meta.getHasNext());
        assertNull(meta.getHasPrevious());
    }
}
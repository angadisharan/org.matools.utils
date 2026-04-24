package org.matools.utils.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {

    @Test
    void shouldBuildSuccessResponse() {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(true)
                .message("Success")
                .data("Hello")
                .build();

        assertTrue(response.isSuccess());
        assertEquals("Success", response.getMessage());
        assertEquals("Hello", response.getData());
        assertNull(response.getError());
        assertNull(response.getMeta());
    }

    @Test
    void shouldBuildErrorResponse() {

        ErrorResponse error = ErrorResponse.builder()
                .code("ERR001")
                .description("Something went wrong")
                .status(500)
                .reason("Internal Server Error")
                .build();

        ApiResponse<Object> response = ApiResponse.builder()
                .success(false)
                .message("Failure")
                .error(error)
                .build();

        assertFalse(response.isSuccess());
        assertEquals(error, response.getError());
        assertEquals("ERR001", response.getError().getCode());
    }

    @Test
    void shouldHandleGenericTypes() {
        ApiResponse<Integer> response = ApiResponse.<Integer>builder()
                .success(true)
                .data(123)
                .build();

        assertEquals(123, response.getData());
    }

    @Test
    void shouldAllowNullOptionalFields() {
        ApiResponse<Object> response = ApiResponse.builder()
                .success(true)
                .build();

        assertTrue(response.isSuccess());
        assertNull(response.getData());
        assertNull(response.getError());
        assertNull(response.getMeta());
    }


}
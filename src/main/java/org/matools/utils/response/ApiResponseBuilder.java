package org.matools.utils.response;

public final class ApiResponseBuilder {

    private ApiResponseBuilder() {}

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> paginated(T data, Meta meta) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .meta(meta)
                .build();
    }

    public static <T> ApiResponse<T> error(String code, String description) {
        return ApiResponse.<T>builder()
                .success(false)
                .error(ErrorResponse.builder()
                        .code(code)
                        .description(description)
                        .build())
                .build();
    }

    public static <T> ApiResponse<T> error(
            String code,
            String description,
            int status,
            String reason
    ) {
        return ApiResponse.<T>builder()
                .success(false)
                .error(ErrorResponse.builder()
                        .code(code)
                        .description(description)
                        .status(status)
                        .reason(reason)
                        .build())
                .build();
    }


}
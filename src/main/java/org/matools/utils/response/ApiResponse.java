package org.matools.utils.response;


public class ApiResponse<T> {

    private final boolean success;
    private final String message;
    private final T data;
    private final ErrorResponse error;
    private final Meta meta;

    private ApiResponse(Builder<T> builder) {
        this.success = builder.success;
        this.message = builder.message;
        this.data = builder.data;
        this.error = builder.error;
        this.meta = builder.meta;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public Meta getMeta() {
        return meta;
    }

    // 🔥 Builder
    public static class Builder<T> {
        private boolean success;
        private String message;
        private T data;
        private ErrorResponse error;
        private Meta meta;

        public Builder<T> success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> error(ErrorResponse error) {
            this.error = error;
            return this;
        }

        public Builder<T> meta(Meta meta) {
            this.meta = meta;
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse<>(this);
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }
}
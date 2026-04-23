package org.matools.utils.response;

public class ErrorResponse {

    private final String code;        // business code
    private final String description; // human message
    private final int status;         // HTTP status
    private final String reason;      // HTTP reason (optional)

    private ErrorResponse(Builder builder) {
        this.code = builder.code;
        this.description = builder.description;
        this.status = builder.status;
        this.reason = builder.reason;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    public static class Builder {
        private String code;
        private String description;
        private int status;
        private String reason;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
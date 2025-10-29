package com.ncu.blog.dto;

public class ApiResponse<T> {
    private String status; // "Success" or "Failed"
    private T data;
    private String error;

    public ApiResponse() {}

    public ApiResponse(String status, T data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("Success", data, null);
    }

    public static <T> ApiResponse<T> failure(String error) {
        return new ApiResponse<>("Failed", null, error);
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}

package org.cana.models;

import lombok.Data;

@Data
public class ErrorMessageModel {
    private String errorCode;
    private String message;

    public ErrorMessageModel(String errorCode, String... message) {
        this.errorCode = errorCode;
    }
}

package org.cana.dtos;

import lombok.Data;

@Data
public class ErrorMsgDto {
    private String errorCode;
    private String message;

    public ErrorMsgDto(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}

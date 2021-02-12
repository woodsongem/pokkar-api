package org.cana.dtos;

import lombok.Data;

@Data
public class ErrorMsgDto {
    private String errorCode;
    private String message;
}

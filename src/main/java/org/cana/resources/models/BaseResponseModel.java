package org.cana.resources.models;

import lombok.Data;

import java.util.List;

@Data
public class BaseResponseModel {
    private List<ErrorMessageModel> errorMessage;
}

package org.cana.services.utilities;

import org.cana.dtos.ErrorMsgDto;
import org.cana.resources.models.ErrorMessageModel;

import java.util.ArrayList;
import java.util.List;

public class PokkarServiceUtility
{
    public static List<ErrorMsgDto> getErrorMessages(String errorCode, String message) {

        return getListOfErrorMessage(errorCode, message);
    }

    public static List<ErrorMsgDto> getErrorMessages(String errorCode) {

        return getListOfErrorMessage(errorCode, null);
    }

    private static List<ErrorMsgDto> getListOfErrorMessage(String errorCode, String message) {

        List<ErrorMsgDto> errorMessages = new ArrayList<>();
        errorMessages.add(getErrorMessage(errorCode, message));
        return errorMessages;
    }

    private static ErrorMsgDto getErrorMessage(String errorCode, String message) {

        return new ErrorMsgDto(errorCode, message);
    }

    public static String getHttpVerbs() {

        return null;
    }

    public static List<ErrorMessageModel> getErrorMessageModel(List<ErrorMsgDto>  errorMessages){
        var errorMessageModels = new ArrayList<ErrorMessageModel>();
        for (ErrorMsgDto errorMessage : errorMessages) {

            errorMessageModels.add(new ErrorMessageModel(errorMessage.getErrorCode(), errorMessage.getMessage()));
        }
        return errorMessageModels;
    }
}

package org.cana.services.roundpoint.errorcodes;

import lombok.Data;
import org.cana.commons.BaseErrorCode;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Data
public class RoundPointErrorCodes extends BaseErrorCode {

    private String gameRoundIdNotFound = "Pokkar.Api.{" + getApiControllerName() + "}.{" + getHttpMethod() + "}.GameRoundId.NotFound";
    private String gamePlayerIdNotFound = "Pokkar.Api.{" + getApiControllerName() + "}.{" + getHttpMethod() + "}.GamePlayerId.NotFound";
    private String getGameIdNotFound = "Pokkar.Api.{" + getApiControllerName() + "}.{" + getHttpMethod() + "}.GameId.NotFound";


}

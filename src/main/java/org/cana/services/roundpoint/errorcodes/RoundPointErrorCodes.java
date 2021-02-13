package org.cana.services.roundpoint.errorcodes;

import lombok.Data;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Data
public class RoundPointErrorCodes {

    private String gameRoundIdNotFound = "Pokkar.Api.{" + getApiControllerName() + "}.{" + getHttpMethod() + "}.GameRoundId.NotFound";
    private String gamePlayerIdNotFound = "Pokkar.Api.{" + getApiControllerName() + "}.{" + getHttpMethod() + "}.GamePlayerId.NotFound";
    private String getGameIdNotFound = "Pokkar.Api.{" + getApiControllerName() + "}.{" + getHttpMethod() + "}.GameId.NotFound";

    public String getHttpMethod() {
        return "NOT";
    }

    public String getApiControllerName() {
        return "NOT";
    }
}

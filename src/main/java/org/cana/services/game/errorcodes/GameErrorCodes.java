package org.cana.services.game.errorcodes;

import lombok.Data;
import org.cana.commons.BaseErrorCode;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Data
public class GameErrorCodes extends BaseErrorCode {
    public static final String gameIdNotNumber = "Pokkar.Api.{0}.{1}.GameId.NotNumber";
    public static final String gameIdIsNull = "Pokkar.Api.{0}.{1}.GameId.IsNull";
    public static final String gameIdIsEmpty = "Pokkar.Api.{0}.{1}.GameId.IsEmpty";
}

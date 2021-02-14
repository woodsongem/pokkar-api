package org.cana.services.gameplayer.errorcodes;

import org.cana.commons.BaseErrorCode;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GamePlayerErrorCodes extends BaseErrorCode {
    public static final String gamePlayerIdIsEmpty = "Pokkar.Api.{0}.{1}.PlayerId.IsNull";
    public static final String gamePlayerIdIsNull = "Pokkar.Api.{0}.{1}.PlayerId.IsEmpty";
    public static final String gamePlayerIdNotNumber = "Pokkar.Api.{0}.{1}.PlayerId.NotNumber";
}

package org.cana.services.lap.errorcodes;

import org.cana.commons.BaseErrorCode;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LapErrorCodes extends BaseErrorCode {
    public static final String gameLapIdIsEmpty = "Pokkar.Api.{0}.{1}.LapId.IsEmpty";
    public static final String gameLapIdIsNull = "Pokkar.Api.{0}.{1}.LapId.IsNull" ;
    public static final String gameLapIdNotNumber = "Pokkar.Api.{0}.{1}.LapId.NotNumber";
}

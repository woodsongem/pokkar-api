package org.cana.resources.roundpoint;

import org.cana.dtos.ErrorMsgDto;
import org.cana.resources.roundpoint.mappers.RoundPointResourceMapper;
import org.cana.resources.roundpoint.models.RoundPointModel;
import org.cana.resources.roundpoint.models.RoundPointResModel;
import org.cana.services.game.errorcodes.GameErrorCodes;
import org.cana.services.gameplayer.errorcodes.GamePlayerErrorCodes;
import org.cana.services.lap.errorcodes.LapErrorCodes;
import org.cana.services.roundpoint.RoundPointService;
import org.cana.services.roundpoint.dtos.RoundPointDto;
import org.cana.services.roundpoint.errorcodes.RoundPointErrorCodes;
import org.cana.services.utilities.PokkarServiceUtility;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/games")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class RoundPointResource {

    @Inject
    RoundPointService roundPointService;

    @Inject
    RoundPointResourceMapper roundPointResourceMapper;

    @Inject
    RoundPointErrorCodes roundPointErrorCodes;

    @Inject
    GamePlayerErrorCodes gamePlayerErrorCodes;

    @Inject
    GameErrorCodes gameErrorCodes;

    @Inject
    LapErrorCodes lapErrorCodes;

    @POST
    @Transactional
    @Path("/{gameId}/players/{playerId}/rounds/{lapId}")
    public RoundPointResModel getRoundPoint(@Valid
                                            @NotBlank(message = GameErrorCodes.gameIdIsEmpty)
                                            @NotEmpty(message = GameErrorCodes.gameIdIsNull)
                                            @Pattern(regexp = "[0-9]+", message = GameErrorCodes.gameIdNotNumber)
                                            @PathParam String gameId,
                                            @NotBlank(message = GamePlayerErrorCodes.gamePlayerIdIsEmpty )
                                            @NotEmpty(message = GamePlayerErrorCodes.gamePlayerIdIsNull )
                                            @Pattern(regexp = "[0-9]+", message = GamePlayerErrorCodes.gamePlayerIdNotNumber)
                                            @PathParam String playerId,
                                            @NotBlank(message = LapErrorCodes.gameLapIdIsEmpty )
                                            @NotEmpty(message = LapErrorCodes.gameLapIdIsNull )
                                            @Pattern(regexp = "[0-9]+", message = LapErrorCodes.gameLapIdNotNumber)
                                            @PathParam String lapId,
                                            @Valid RoundPointModel roundPointModel) {
        RoundPointDto roundPointDto = roundPointResourceMapper.mapRoundPointDto(gameId, playerId, lapId, roundPointModel);
        List<ErrorMsgDto> errors = roundPointService.add(roundPointDto);
        RoundPointResModel roundPointResModel = new RoundPointResModel();
        if(!errors.isEmpty()){
            roundPointResModel.setErrorMessage(PokkarServiceUtility.getErrorMessageModel(errors));
            return roundPointResModel;
        }

        roundPointResModel.setId(roundPointDto.getId());
        return roundPointResModel;
    }
}

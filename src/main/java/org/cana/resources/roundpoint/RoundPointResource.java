package org.cana.resources.roundpoint;

import org.cana.dtos.ErrorMsgDto;
import org.cana.resources.roundpoint.mappers.RoundPointResourceMapper;
import org.cana.resources.roundpoint.models.RoundPointModel;
import org.cana.resources.roundpoint.models.RoundPointResModel;
import org.cana.services.roundpoint.RoundPointService;
import org.cana.services.roundpoint.dtos.RoundPointDto;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    @POST
    @Transactional
    @Path("/{gameId}/players/{playerId}/rounds/{roundId}")
    public RoundPointResModel getRoundPoint(@Valid
                                            @NotBlank(message = "Pokkar.Api.{0}.{1}.GameId.IsNull")
                                            @NotEmpty(message = "Pokkar.Api.{0}.{1}.GameId.IsEmpty")
                                            @PathParam String gameId,
                                            @NotBlank(message = "Pokkar.Api.{0}.{1}.playerId.IsNull")
                                            @NotEmpty(message = "Pokkar.Api.{0}.{1}.playerId.IsEmpty")
                                            @PathParam String playerId,
                                            @NotBlank(message = "Pokkar.Api.{0}.{1}.roundId.IsNull")
                                            @NotEmpty(message = "Pokkar.Api.{0}.{1}.roundId.IsEmpty")
                                            @PathParam String roundId,
                                            @RequestBody RoundPointModel roundPointModel) {
        RoundPointDto roundPointDto = roundPointResourceMapper.mapRoundPointDto(gameId, playerId, roundId, roundPointModel);
        List<ErrorMsgDto> errors = roundPointService.add(roundPointDto);
        RoundPointResModel roundPointResModel = new RoundPointResModel();
        roundPointResModel.setId(roundPointDto.getId());
        return roundPointResModel;
    }
}

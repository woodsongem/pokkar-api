package org.cana.resources.roundpoint;

import org.cana.dtos.ErrorMsgDto;
import org.cana.resources.roundpoint.mappers.RoundPointResourceMapper;
import org.cana.resources.roundpoint.models.RoundPointModel;
import org.cana.resources.roundpoint.models.RoundPointResModel;
import org.cana.roundpoint.service.RoundPointService;
import org.cana.roundpoint.service.dtos.RoundPointDto;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
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
                                            @PathParam String gameId,
                                            @PathParam String playerId,
                                            @PathParam String roundId,
                                            @RequestBody RoundPointModel roundPointModel) {
        RoundPointDto roundPointDto = roundPointResourceMapper.mapRoundPointDto(gameId, playerId, roundId, roundPointModel);
        List<ErrorMsgDto> errors = roundPointService.add(roundPointDto);
        RoundPointResModel roundPointResModel = new RoundPointResModel();
        return roundPointResModel;
    }
}

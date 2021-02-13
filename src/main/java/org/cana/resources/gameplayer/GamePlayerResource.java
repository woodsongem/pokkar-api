package org.cana.resources.gameplayer;

import org.cana.dtos.ErrorMsgDto;
import org.cana.resources.gameplayer.mappers.GamePlayerMapper;
import org.cana.resources.gameplayer.models.CreateGamePlayerModel;
import org.cana.resources.gameplayer.models.CreateGamePlayerResModel;
import org.cana.resources.gameplayer.models.GamePlayerModel;
import org.cana.services.gameplayer.GamePlayerService;
import org.cana.services.gameplayer.dtos.GamePlayerDto;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("/games")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GamePlayerResource {

    @Inject
    GamePlayerService gamePlayerService;

    @Inject
    GamePlayerMapper gamePlayerMapper;

    @POST
    @Transactional
    @Path("/{gameId}/players")
    public CreateGamePlayerResModel add(@PathParam String gameId, @RequestBody CreateGamePlayerModel createGamePlayerModel) {
        GamePlayerDto gamePlayerDto = gamePlayerMapper.mapGamePlayerDto(gameId, createGamePlayerModel);
        List<ErrorMsgDto> errors  = gamePlayerService.add(gamePlayerDto);
        CreateGamePlayerResModel createGamePlayerResModel= new CreateGamePlayerResModel();
        createGamePlayerResModel.setId(gamePlayerDto.getId());
        return  createGamePlayerResModel;
    }

    @GET
    @Transactional
    @Path("/{gameId}/players")
    public Set<GamePlayerModel> getGamePlayer(@PathParam String gameId)
    {
       var gamePlayers = gamePlayerService.getGamePlayer(gameId);
       return gamePlayerMapper.mapGamePlayerModels(gamePlayers);
    }
}

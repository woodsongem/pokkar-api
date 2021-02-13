package org.cana.resources.game;

import org.cana.dtos.ErrorMsgDto;
import org.cana.resources.game.mappers.GameMapper;
import org.cana.resources.game.models.CreateGameModel;
import org.cana.resources.game.models.CreateGameResModel;
import org.cana.resources.game.models.GameModel;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.List;

import org.cana.services.game.GameService;
import org.cana.services.game.dtos.CreateGameDto;
import org.cana.services.game.repository.daos.Games;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/games")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {
    @Inject
    GameService gameService;

    @Inject
    GameMapper gameMapper;

    @POST
    @Transactional
    public CreateGameResModel add(@Valid CreateGameModel createGameModel) {
        CreateGameDto createGameDto = gameMapper.mapCreateGameDto(createGameModel);
        List<ErrorMsgDto> errors = gameService.add(createGameDto);
        CreateGameResModel createGameResModel = new CreateGameResModel();
        createGameResModel.setId(createGameDto.getId());
        return createGameResModel;
    }

    @GET
    @Path("/{gameId}")
    public GameModel get(@PathParam String gameId) {
        Games games = gameService.getGame(gameId);
        return gameMapper.mapGameModel(games);
    }
}

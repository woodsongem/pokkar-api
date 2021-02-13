package org.cana.resources.game.mappers;

import com.googlecode.jmapper.JMapper;
import org.cana.resources.game.models.CreateGameModel;
import org.cana.resources.game.models.GameModel;
import org.cana.services.game.dtos.CreateGameDto;
import org.cana.services.game.repository.daos.Games;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameMapperImpl implements GameMapper
{
    JMapper<CreateGameDto, CreateGameModel> createGameDtoMapper;
    JMapper<GameModel, Games> gameModelMapper;

    GameMapperImpl()
    {
        createGameDtoMapper = new JMapper<>(CreateGameDto.class,CreateGameModel.class);
        gameModelMapper = new JMapper<>(GameModel.class,Games.class);
    }

    @Override
    public CreateGameDto mapCreateGameDto(CreateGameModel createGameModel)
    {
        return createGameDtoMapper.getDestination(createGameModel);
    }

    @Override
    public GameModel mapGameModel(Games games) {
        return gameModelMapper.getDestination(games);
    }
}

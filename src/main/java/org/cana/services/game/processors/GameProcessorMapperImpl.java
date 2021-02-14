package org.cana.services.game.processors;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import org.cana.services.game.dtos.CreateGameDto;
import org.cana.services.game.repository.daos.Games;
import org.cana.services.gameplayer.repository.daos.GamePlayer;
import org.cana.services.lap.repository.daos.GameLap;

import javax.enterprise.context.ApplicationScoped;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

@ApplicationScoped
public class GameProcessorMapperImpl implements GameProcessorMapper {

    JMapper<Games, CreateGameDto> gamesMapper;
    JMapper<GamePlayer, CreateGameDto> gamePlayerMapper;
    JMapper<GameLap, CreateGameDto> gameRoundMapper;

    GameProcessorMapperImpl() {
        gamesMapper = new JMapper<>(Games.class, CreateGameDto.class);
        JMapperAPI gamePlayerMapperAPI = new JMapperAPI()
                .add(mappedClass(GamePlayer.class)
                        .add(attribute("name").value("name"))
                        .add(attribute("createdBy").value("createdBy"))
                        .add(attribute("createdOn").value("createdOn"))
                        .add(attribute("modifiedBy").value("modifiedBy"))
                        .add(attribute("modifiedOn").value("modifiedOn")));
        gamePlayerMapper = new JMapper<>(GamePlayer.class, CreateGameDto.class, gamePlayerMapperAPI);

        JMapperAPI gameRoundMapperAPI = new JMapperAPI()
                .add(mappedClass(GameLap.class)
                        .add(attribute("gameId").value("id"))
                        .add(attribute("gamePlayerId").value("gamePlayerId"))
                        .add(attribute("createdBy").value("createdBy"))
                        .add(attribute("createdOn").value("createdOn"))
                        .add(attribute("modifiedBy").value("modifiedBy"))
                        .add(attribute("modifiedOn").value("modifiedOn")));

        gameRoundMapper = new JMapper<>(GameLap.class, CreateGameDto.class,gameRoundMapperAPI);
    }

    @Override
    public Games mapGames(CreateGameDto createGameDto) {
        return gamesMapper.getDestination(createGameDto);
    }

    @Override
    public GamePlayer mapGamePlayer(CreateGameDto createGameDto) {
        return gamePlayerMapper.getDestination(createGameDto);
    }

    @Override
    public GameLap mapGameRound(CreateGameDto createGameDto) {
        return gameRoundMapper.getDestination(createGameDto);
    }
}

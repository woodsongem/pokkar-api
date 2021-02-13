package org.cana.resources.gameplayer.mappers;

import com.googlecode.jmapper.JMapper;
import org.cana.resources.gameplayer.models.CreateGamePlayerModel;
import org.cana.resources.gameplayer.models.GamePlayerModel;
import org.cana.services.gameplayer.dtos.GamePlayerDto;
import org.cana.services.gameplayer.repository.daos.GamePlayer;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class GamePlayerMapperImpl implements GamePlayerMapper {

    JMapper<GamePlayerDto, CreateGamePlayerModel> createGamePlayerModelMapper;
    JMapper<GamePlayerModel, GamePlayer> gamePlayerModelMapper;

    GamePlayerMapperImpl() {
        createGamePlayerModelMapper = new JMapper<>(GamePlayerDto.class, CreateGamePlayerModel.class);
        gamePlayerModelMapper = new JMapper<>(GamePlayerModel.class,GamePlayer.class);
    }

    @Override
    public GamePlayerDto mapGamePlayerDto(String gameId, CreateGamePlayerModel createGamePlayerModel) {
        GamePlayerDto gamePlayerDto = createGamePlayerModelMapper.getDestination(createGamePlayerModel);
        gamePlayerDto.setGameId(gameId);
        return gamePlayerDto;
    }

    @Override
    public Set<GamePlayerModel> mapGamePlayerModels(List<GamePlayer> gamePlayers) {
        Set<GamePlayerModel> gamePlayerModels = new HashSet<>();
        for (GamePlayer gamePlayer: gamePlayers) {
            gamePlayerModels.add(gamePlayerModelMapper.getDestination(gamePlayer));
        }
        return gamePlayerModels;
    }
}

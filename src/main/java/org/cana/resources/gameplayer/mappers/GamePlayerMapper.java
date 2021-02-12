package org.cana.resources.gameplayer.mappers;

import org.cana.gameplayer.service.dtos.GamePlayerDto;
import org.cana.gameplayer.service.repository.daos.GamePlayer;
import org.cana.resources.gameplayer.models.CreateGamePlayerModel;
import org.cana.resources.gameplayer.models.GamePlayerModel;

import java.util.List;
import java.util.Set;

public interface GamePlayerMapper {
    GamePlayerDto mapGamePlayerDto(String gameId, CreateGamePlayerModel createGamePlayerModel);

    Set<GamePlayerModel> mapGamePlayerModels(List<GamePlayer> gamePlayers);
}

package org.cana.resources.gameplayer.mappers;

import org.cana.resources.gameplayer.models.CreateGamePlayerModel;
import org.cana.resources.gameplayer.models.GamePlayerModel;
import org.cana.services.gameplayer.dtos.GamePlayerDto;
import org.cana.services.gameplayer.repository.daos.GamePlayer;

import java.util.List;
import java.util.Set;

public interface GamePlayerMapper {
    GamePlayerDto mapGamePlayerDto(String gameId, CreateGamePlayerModel createGamePlayerModel);

    Set<GamePlayerModel> mapGamePlayerModels(List<GamePlayer> gamePlayers);
}

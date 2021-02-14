package org.cana.services.game.processors;

import org.cana.services.game.dtos.CreateGameDto;
import org.cana.services.game.repository.daos.Games;
import org.cana.services.gameplayer.repository.daos.GamePlayer;
import org.cana.services.lap.repository.daos.GameLap;

public interface GameProcessorMapper {
    Games mapGames(CreateGameDto createGameDto);

    GamePlayer mapGamePlayer(CreateGameDto createGameDto);

    GameLap mapGameRound(CreateGameDto createGameDto);
}

package org.cana.services.game.processors;


import org.cana.gameplayer.service.repository.daos.GamePlayer;
import org.cana.gameplayer.service.repository.daos.GameRound;
import org.cana.services.game.dtos.CreateGameDto;
import org.cana.services.game.repository.daos.Games;

public interface GameProcessorMapper {
    Games mapGames(CreateGameDto createGameDto);

    GamePlayer mapGamePlayer(CreateGameDto createGameDto);

    GameRound mapGameRound(CreateGameDto createGameDto);
}

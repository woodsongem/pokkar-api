package org.cana.game.service.mappers;

import org.cana.game.service.dtos.CreateGameDto;
import org.cana.game.service.repository.daos.Games;

public interface GameServiceMapper {
    Games mapGames(CreateGameDto createGameDto);
}

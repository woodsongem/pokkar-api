package org.cana.services.game;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.game.dtos.CreateGameDto;
import org.cana.services.game.repository.daos.Games;


import java.util.List;

public interface GameService
{
    List<ErrorMsgDto> add(CreateGameDto createGameDto);

    Games getGame(String gameId);
}

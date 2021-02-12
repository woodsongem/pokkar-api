package org.cana.game.service;

import org.cana.dtos.ErrorMsgDto;
import org.cana.game.service.dtos.CreateGameDto;
import org.cana.game.service.repository.daos.Games;

import java.util.List;

public interface GameService
{
    List<ErrorMsgDto> add(CreateGameDto createGameDto);

    Games getGame(String gameId);
}

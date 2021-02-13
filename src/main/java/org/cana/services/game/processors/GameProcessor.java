package org.cana.services.game.processors;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.game.dtos.CreateGameDto;

import java.util.List;

public interface GameProcessor {
    List<ErrorMsgDto> processCreateGame(CreateGameDto createGameDto);

    List<ErrorMsgDto> createGame(CreateGameDto createGameDto);

    List<ErrorMsgDto> createGamePlayer(CreateGameDto createGameDto);

    List<ErrorMsgDto> createGameRound(CreateGameDto createGameDto);
}

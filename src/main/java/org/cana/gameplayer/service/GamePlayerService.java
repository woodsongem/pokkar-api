package org.cana.gameplayer.service;

import org.cana.dtos.ErrorMsgDto;
import org.cana.gameplayer.service.dtos.GamePlayerDto;
import org.cana.gameplayer.service.repository.daos.GamePlayer;

import java.util.List;

public interface GamePlayerService {
    List<ErrorMsgDto> add(GamePlayerDto gamePlayerDto);

    List<GamePlayer> getGamePlayer(String gameId);
}

package org.cana.services.gameplayer;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.gameplayer.dtos.GamePlayerDto;
import org.cana.services.gameplayer.repository.daos.GamePlayer;

import java.util.List;

public interface GamePlayerService {
    List<ErrorMsgDto> add(GamePlayerDto gamePlayerDto);

    List<GamePlayer> getGamePlayer(String gameId);
}

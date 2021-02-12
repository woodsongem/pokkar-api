package org.cana.gameplayer.service.mappers;

import org.cana.gameplayer.service.dtos.GamePlayerDto;
import org.cana.gameplayer.service.repository.daos.GamePlayer;

public interface GamePlayerServiceMapper {
    GamePlayer mapGamePlayer(GamePlayerDto gamePlayerDto);
}

package org.cana.services.gameplayer.mappers;

import org.cana.services.gameplayer.dtos.GamePlayerDto;
import org.cana.services.gameplayer.repository.daos.GamePlayer;

public interface GamePlayerServiceMapper {
    GamePlayer mapGamePlayer(GamePlayerDto gamePlayerDto);
}

package org.cana.services.gameplayer.mappers;


import org.cana.gameplayer.service.repository.daos.GamePlayer;
import org.cana.services.gameplayer.dtos.GamePlayerDto;

public interface GamePlayerServiceMapper {
    GamePlayer mapGamePlayer(GamePlayerDto gamePlayerDto);
}

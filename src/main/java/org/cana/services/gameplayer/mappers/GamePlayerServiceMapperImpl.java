package org.cana.services.gameplayer.mappers;

import com.googlecode.jmapper.JMapper;
import org.cana.gameplayer.service.repository.daos.GamePlayer;
import org.cana.services.gameplayer.dtos.GamePlayerDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GamePlayerServiceMapperImpl implements GamePlayerServiceMapper {

    JMapper<GamePlayer, GamePlayerDto> gamePlayerMapper;

    GamePlayerServiceMapperImpl() {
        gamePlayerMapper = new JMapper<>(GamePlayer.class, GamePlayerDto.class);
    }

    @Override
    public GamePlayer mapGamePlayer(GamePlayerDto gamePlayerDto) {
        return gamePlayerMapper.getDestination(gamePlayerDto);
    }
}

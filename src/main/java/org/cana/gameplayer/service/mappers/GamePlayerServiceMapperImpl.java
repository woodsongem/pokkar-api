package org.cana.gameplayer.service.mappers;

import com.googlecode.jmapper.JMapper;
import org.cana.gameplayer.service.dtos.GamePlayerDto;
import org.cana.gameplayer.service.repository.daos.GamePlayer;

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

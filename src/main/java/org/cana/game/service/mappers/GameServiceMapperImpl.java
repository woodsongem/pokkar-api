package org.cana.game.service.mappers;

import com.googlecode.jmapper.JMapper;
import org.cana.game.service.dtos.CreateGameDto;
import org.cana.game.service.repository.daos.Games;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameServiceMapperImpl implements GameServiceMapper {

    JMapper<Games, CreateGameDto> gamesMapper;

    GameServiceMapperImpl()
    {
        gamesMapper = new JMapper<>(Games.class,CreateGameDto.class);
    }

    @Override
    public Games mapGames(CreateGameDto createGameDto) {
        return  gamesMapper.getDestination(createGameDto);
    }
}

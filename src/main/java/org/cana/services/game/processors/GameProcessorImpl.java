package org.cana.services.game.processors;

import org.cana.dtos.ErrorMsgDto;

import org.cana.services.game.dtos.CreateGameDto;
import org.cana.services.game.repository.GameRepository;
import org.cana.services.game.repository.daos.Games;
import org.cana.services.gameplayer.repository.GamePlayerRepository;
import org.cana.services.gameplayer.repository.GameRoundRepository;
import org.cana.services.gameplayer.repository.daos.GamePlayer;
import org.cana.services.gameplayer.repository.daos.GameRound;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class GameProcessorImpl implements GameProcessor {
    @Inject
    GameRepository gameRepository;

    @Inject
    GamePlayerRepository gamePlayerRepository;

    @Inject
    GameProcessorMapper gameProcessorMapper;

    @Inject
    GameRoundRepository gameRoundRepository;

    @Override
    public List<ErrorMsgDto> processCreateGame(CreateGameDto createGameDto) {
        List<ErrorMsgDto> errors = createGame(createGameDto);
        if(!errors.isEmpty())
        {
            return errors;
        }

        errors = createGamePlayer(createGameDto);
        if(!errors.isEmpty())
        {
            return errors;
        }

        errors = createGameRound(createGameDto);
        return errors;
    }

    @Override
    public List<ErrorMsgDto> createGame(CreateGameDto createGameDto)
    {
        Games games =  gameProcessorMapper.mapGames(createGameDto);
        gameRepository.persist(games);
        createGameDto.setId(games.getId());
        return Collections.emptyList();
    }

    @Override
    public List<ErrorMsgDto> createGamePlayer(CreateGameDto createGameDto)
    {
        GamePlayer gamePlayer = gameProcessorMapper.mapGamePlayer(createGameDto);
        gamePlayer.setIsActive(true);
        gamePlayerRepository.persist(gamePlayer);
        createGameDto.setGamePlayerId(gamePlayer.getId());
        return Collections.emptyList();
    }

    @Override
    public List<ErrorMsgDto> createGameRound(CreateGameDto createGameDto)
    {
        GameRound gameRound = gameProcessorMapper.mapGameRound(createGameDto);
        gameRound.setIsActive(true);
        gameRoundRepository.persist(gameRound);
        createGameDto.setGameRoundId(gameRound.getId());
        return Collections.emptyList();
    }
}

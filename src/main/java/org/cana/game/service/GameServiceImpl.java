package org.cana.game.service;

import org.apache.commons.lang3.StringUtils;
import org.cana.dtos.ErrorMsgDto;
import org.cana.game.service.dtos.CreateGameDto;
import org.cana.game.service.dtos.GameStatus;
import org.cana.game.service.mappers.GameServiceMapper;
import org.cana.game.service.repository.GameRepository;
import org.cana.game.service.repository.daos.Games;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class GameServiceImpl implements GameService {

    @Inject
    GameRepository gameRepository;

    @Inject
    GameServiceMapper gameServiceMapper;

    @Override
    public List<ErrorMsgDto> add(CreateGameDto createGameDto) {

        if(createGameDto != null)
        {
            var currentDate = new Date();
            createGameDto.setCreatedOn(currentDate);
            createGameDto.setModifiedOn(currentDate);

            if(!StringUtils.isEmpty(createGameDto.getUserid()))
            {
                createGameDto.setCreatedBy(createGameDto.getUserid());
                createGameDto.setModifiedBy(createGameDto.getUserid());
            }
            else
            {
                createGameDto.setCreatedBy("NOT PASSED");
                createGameDto.setModifiedBy("NOT PASSED");
                createGameDto.setUserid("0");
                createGameDto.setParsedUserId(0L);
            }
            createGameDto.setStatus(GameStatus.CREATED);
        }

        Games games =  gameServiceMapper.mapGames(createGameDto);
        gameRepository.persist(games);
        createGameDto.setId(games.getId());
        return Collections.emptyList();
    }

    @Override
    public Games getGame(String gameId)
    {
        return gameRepository.findById(Long.parseLong(gameId));
    }
}

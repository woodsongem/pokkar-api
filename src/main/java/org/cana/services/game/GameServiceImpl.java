package org.cana.services.game;

import org.apache.commons.lang3.StringUtils;
import org.cana.dtos.ErrorMsgDto;
import org.cana.services.game.dtos.CreateGameDto;
import org.cana.services.game.dtos.GameStatus;
import org.cana.services.game.mappers.GameServiceMapper;
import org.cana.services.game.processors.GameProcessor;
import org.cana.services.game.repository.GameRepository;
import org.cana.services.game.repository.daos.Games;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class GameServiceImpl implements GameService {

    @Inject
    GameRepository gameRepository;

    @Inject
    GameServiceMapper gameServiceMapper;

    @Inject
    GameProcessor gameProcessor;

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
                createGameDto.setCreatedBy("");
                createGameDto.setModifiedBy("");
                createGameDto.setUserid("0");
                createGameDto.setParsedUserId(0L);
            }
            createGameDto.setStatus(GameStatus.CREATED);
        }

        List<ErrorMsgDto> errors = gameProcessor.processCreateGame(createGameDto);
        return errors;
    }

    @Override
    public Games getGame(String gameId)
    {
        return gameRepository.findById(Long.parseLong(gameId));
    }
}

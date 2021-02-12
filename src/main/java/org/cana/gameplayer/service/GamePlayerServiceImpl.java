package org.cana.gameplayer.service;

import org.apache.commons.lang3.StringUtils;
import org.cana.dtos.ErrorMsgDto;
import org.cana.game.service.dtos.GameStatus;
import org.cana.gameplayer.service.dtos.GamePlayerDto;
import org.cana.gameplayer.service.mappers.GamePlayerServiceMapper;
import org.cana.gameplayer.service.repository.GamePlayerRepository;
import org.cana.gameplayer.service.repository.daos.GamePlayer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class GamePlayerServiceImpl implements GamePlayerService {

    @Inject
    GamePlayerRepository gamePlayerRepository;

    @Inject
    GamePlayerServiceMapper gamePlayerServiceMapper;

    @Override
    public List<ErrorMsgDto> add(GamePlayerDto gamePlayerDto) {

        if (gamePlayerDto != null) {
            var currentDate = new Date();
            gamePlayerDto.setCreatedOn(currentDate);
            gamePlayerDto.setModifiedOn(currentDate);

            if (!StringUtils.isEmpty(gamePlayerDto.getUserId())) {
                gamePlayerDto.setCreatedBy(gamePlayerDto.getUserId());
                gamePlayerDto.setModifiedBy(gamePlayerDto.getUserId());
            } else {
                gamePlayerDto.setCreatedBy("");
                gamePlayerDto.setModifiedBy("");
                gamePlayerDto.setUserId("0");
                gamePlayerDto.setParsedUserId(0L);
            }
            gamePlayerDto.setIsActive(true);
        }

        GamePlayer gamePlayer = gamePlayerServiceMapper.mapGamePlayer(gamePlayerDto);
        gamePlayerRepository.persist(gamePlayer);
        gamePlayerDto.setId(gamePlayer.getId());
        return Collections.emptyList();
    }

    @Override
    public List<GamePlayer> getGamePlayer(String gameId) {
        int parsedGameId = Integer.parseInt(gameId);
        return gamePlayerRepository.findByIdAndIsActive(parsedGameId);
    }
}

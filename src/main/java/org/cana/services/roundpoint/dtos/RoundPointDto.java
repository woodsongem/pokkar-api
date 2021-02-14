package org.cana.services.roundpoint.dtos;

import lombok.Data;
import org.cana.dtos.BaseDto;
import org.cana.services.game.repository.daos.Games;
import org.cana.services.gameplayer.repository.daos.GamePlayer;
import org.cana.services.lap.repository.daos.GameLap;

@Data
public class RoundPointDto extends BaseDto
{
    private Long id;
    private String gameId;
    private String playerId;
    private String roundId;
    private Long parsedGameId;
    private Long parsedPlayerId;
    private Long parsedRoundId;
    private String point;
    private GamePlayer gamePlayer;
    private GameLap gameRound;
    private Games games;
    private String userId;
    private Long parsedUserId;
}

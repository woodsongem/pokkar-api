package org.cana.services.roundpoint.dtos;

import lombok.Data;
import org.cana.dtos.BaseDto;
import org.cana.services.gameplayer.repository.daos.GamePlayer;
import org.cana.services.gameplayer.repository.daos.GameRound;

@Data
public class RoundPointDto extends BaseDto
{
    private Long id;
    private String gameId;
    private Long parsedGameId;
    private String playerId;
    private Long parsedPlayerId;
    private String roundId;
    private Long parsedRoundId;
    private Long point;
    private GamePlayer gamePlayer;
    private GameRound gameRound;
}

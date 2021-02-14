package org.cana.resources.roundpoint.mappers;


import org.cana.resources.roundpoint.models.RoundPointModel;
import org.cana.services.roundpoint.dtos.RoundPointDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoundPointResourceMapperImpl implements  RoundPointResourceMapper {

    RoundPointResourceMapperImpl ()
    {

    }

    @Override
    public RoundPointDto mapRoundPointDto(String gameId, String playerId, String lapId, RoundPointModel roundPointModel) {
        RoundPointDto roundPointDto= new RoundPointDto();
        roundPointDto.setRoundId(lapId);
        roundPointDto.setGameId(gameId);
        roundPointDto.setPlayerId(playerId);
        roundPointDto.setPoint(roundPointModel.getPoint());
        return roundPointDto;
    }
}

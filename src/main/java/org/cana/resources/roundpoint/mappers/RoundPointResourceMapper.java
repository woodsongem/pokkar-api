package org.cana.resources.roundpoint.mappers;

import org.cana.resources.roundpoint.models.RoundPointModel;
import org.cana.roundpoint.service.dtos.RoundPointDto;

public interface RoundPointResourceMapper {
    RoundPointDto mapRoundPointDto(String gameId, String playerId, String roundId, RoundPointModel roundPointModel);
}

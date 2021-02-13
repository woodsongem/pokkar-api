package org.cana.services.roundpoint.dtos;

import lombok.Data;
import org.cana.dtos.BaseDto;

@Data
public class RoundPointDto extends BaseDto
{
    private Long id;
    private String gameId;
    private String playerId;
    private String roundId;
    private String point;
}

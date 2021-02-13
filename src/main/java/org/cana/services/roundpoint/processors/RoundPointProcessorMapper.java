package org.cana.services.roundpoint.processors;

import org.cana.services.roundpoint.dtos.RoundPointDto;
import org.cana.services.roundpoint.repository.daos.RoundPoint;

public interface RoundPointProcessorMapper {
    RoundPoint mapRoundPoint(RoundPointDto roundPointDto);
}

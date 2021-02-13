package org.cana.services.roundpoint.processors;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.roundpoint.dtos.RoundPointDto;

import java.util.List;

public interface RoundPointProcessor {
    List<ErrorMsgDto> processCreateRoundPoint(RoundPointDto roundPointDto);

    List<ErrorMsgDto> createRoundPoint(RoundPointDto roundPointDto);
}

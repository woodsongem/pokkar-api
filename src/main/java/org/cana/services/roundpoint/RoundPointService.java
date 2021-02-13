package org.cana.services.roundpoint;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.roundpoint.dtos.RoundPointDto;

import java.util.List;

public interface RoundPointService {
    List<ErrorMsgDto> add(RoundPointDto roundPointDto);
}

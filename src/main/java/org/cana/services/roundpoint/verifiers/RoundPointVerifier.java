package org.cana.services.roundpoint.verifiers;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.roundpoint.dtos.RoundPointDto;

import java.util.List;

public interface RoundPointVerifier {
    List<ErrorMsgDto> verifyCreateRoundPoint(RoundPointDto roundPointDto);

    List<ErrorMsgDto> isGameIdValid(RoundPointDto roundPointDto);

    List<ErrorMsgDto> isGamePlayerIdValid(RoundPointDto roundPointDto);

    List<ErrorMsgDto> isGameRoundIdValid(RoundPointDto roundPointDto);
}

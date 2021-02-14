package org.cana.services.roundpoint;

import org.apache.commons.lang3.StringUtils;
import org.cana.dtos.ErrorMsgDto;
import org.cana.services.roundpoint.dtos.RoundPointDto;
import org.cana.services.roundpoint.processors.RoundPointProcessor;
import org.cana.services.roundpoint.repository.RoundPointRepository;
import org.cana.services.roundpoint.verifiers.RoundPointVerifier;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class RoundPointServiceImpl implements RoundPointService {

    @Inject
    RoundPointRepository roundPointRepository;

    @Inject
    RoundPointVerifier roundPointVerifier;

    @Inject
    RoundPointProcessor roundPointProcessor;

    @Override
    public List<ErrorMsgDto> add(RoundPointDto roundPointDto) {
        if (roundPointDto != null) {
            var currentDate = new Date();
            roundPointDto.setCreatedOn(currentDate);
            roundPointDto.setModifiedOn(currentDate);

            if (!StringUtils.isEmpty(roundPointDto.getUserId())) {
                roundPointDto.setCreatedBy(roundPointDto.getUserId());
                roundPointDto.setModifiedBy(roundPointDto.getUserId());
            } else {
                roundPointDto.setCreatedBy("");
                roundPointDto.setModifiedBy("");
                roundPointDto.setUserId("0");
                roundPointDto.setParsedUserId(0L);
            }
        }
        roundPointDto.setParsedRoundId(Long.parseLong(roundPointDto.getRoundId()));
        roundPointDto.setParsedGameId(Long.parseLong(roundPointDto.getGameId()));
        roundPointDto.setParsedPlayerId(Long.parseLong(roundPointDto.getPlayerId()));

        List<ErrorMsgDto> errors = roundPointVerifier.verifyCreateRoundPoint(roundPointDto);
        if (!errors.isEmpty()) {
            return errors;
        }

        errors = roundPointProcessor.processCreateRoundPoint(roundPointDto);

        return Collections.emptyList();
    }
}

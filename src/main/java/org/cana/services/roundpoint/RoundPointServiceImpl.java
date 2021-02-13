package org.cana.services.roundpoint;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.roundpoint.dtos.RoundPointDto;
import org.cana.services.roundpoint.repository.RoundPointRepository;
import org.cana.services.roundpoint.verifiers.RoundPointVerifier;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RoundPointServiceImpl implements RoundPointService {

    @Inject
    RoundPointRepository roundPointRepository;

    @Inject
    RoundPointVerifier roundPointVerifier;

    @Override
    public List<ErrorMsgDto> add(RoundPointDto roundPointDto) {
        List<ErrorMsgDto> errors = roundPointVerifier.verifyCreateRoundPoint(roundPointDto);
        return null;
    }
}

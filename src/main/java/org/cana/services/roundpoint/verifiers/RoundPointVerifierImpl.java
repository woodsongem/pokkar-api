package org.cana.services.roundpoint.verifiers;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.roundpoint.dtos.RoundPointDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RoundPointVerifierImpl implements  RoundPointVerifier {
    @Override
    public List<ErrorMsgDto> verifyCreateRoundPoint(RoundPointDto roundPointDto) {
        return null;
    }
}

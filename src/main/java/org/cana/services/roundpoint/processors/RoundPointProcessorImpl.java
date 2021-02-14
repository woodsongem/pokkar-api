package org.cana.services.roundpoint.processors;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.roundpoint.dtos.RoundPointDto;
import org.cana.services.roundpoint.repository.RoundPointRepository;
import org.cana.services.roundpoint.repository.daos.RoundPoint;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class RoundPointProcessorImpl implements RoundPointProcessor {
    @Inject
    RoundPointRepository roundPointRepository;

    @Inject
    RoundPointProcessorMapper roundPointProcessorMapper;

    @Override
    public List<ErrorMsgDto> processCreateRoundPoint(RoundPointDto roundPointDto) {

        List<ErrorMsgDto> errors = createRoundPoint(roundPointDto);
        if(!errors.isEmpty())
        {
            return errors;
        }

        return Collections.emptyList();
    }

    @Override
    public List<ErrorMsgDto> createRoundPoint(RoundPointDto roundPointDto) {
        RoundPoint roundPoint = roundPointProcessorMapper.mapRoundPoint(roundPointDto);
        roundPoint.setIsActive(true);
        roundPointRepository.persistAndFlush(roundPoint);
        roundPointDto.setId(roundPoint.getId());
        return Collections.emptyList();
    }
}

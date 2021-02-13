package org.cana.services.roundpoint.processors;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import org.cana.services.gameplayer.repository.daos.GamePlayer;
import org.cana.services.roundpoint.dtos.RoundPointDto;
import org.cana.services.roundpoint.repository.daos.RoundPoint;

import javax.enterprise.context.ApplicationScoped;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

@ApplicationScoped
public class RoundPointProcessorMapperImpl implements RoundPointProcessorMapper {

    JMapper<RoundPoint, RoundPointDto> roundPointMapper;

    RoundPointProcessorMapperImpl() {
        JMapperAPI roundPointMapperApi = new JMapperAPI()
                .add(mappedClass(RoundPointDto.class)
                        .add(attribute("roundId").value("parsedRoundId"))
                        .add(attribute("playerId").value("parsedPlayerId"))
                        .add(attribute("point").value("point"))
                        .add(attribute("createdBy").value("createdBy"))
                        .add(attribute("createdOn").value("createdOn"))
                        .add(attribute("modifiedBy").value("modifiedBy"))
                        .add(attribute("modifiedOn").value("modifiedOn")));
        roundPointMapper = new JMapper<>(RoundPoint.class, RoundPointDto.class, roundPointMapperApi);
    }

    @Override
    public RoundPoint mapRoundPoint(RoundPointDto roundPointDto) {
        return roundPointMapper.getDestination(roundPointDto);
    }
}

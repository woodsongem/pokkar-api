package org.cana.services.lap.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.cana.services.lap.repository.daos.GameLap;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GameLapRepository implements PanacheRepository<GameLap>
{
    public List<GameLap> findByIdAndGameidAndGameplayerid(Long lapId, Long gameId, Long playerId)
    {
        return list("id = ?1 and gameid = ?2 and gameplayerid = ?3 and isactive=true",lapId,gameId,playerId);
    }
}

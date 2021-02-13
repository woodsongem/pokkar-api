package org.cana.services.gameplayer.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.cana.services.gameplayer.repository.daos.GameRound;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GameRoundRepository implements PanacheRepository<GameRound>
{
    public List<GameRound> findByIdAndGameidAndGameplayerid(Long roundId, Long gameId, Long playerId)
    {
        return list("id = ?1 and gameid = ?2 and gameplayerid = ?3 and isactive=true",roundId,gameId,playerId);
    }
}

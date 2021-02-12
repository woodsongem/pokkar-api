package org.cana.gameplayer.service.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.cana.gameplayer.service.repository.daos.GamePlayer;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class GamePlayerRepository implements PanacheRepository<GamePlayer>
{
    public List<GamePlayer> findByIdAndIsActive(int gameId)
    {
        return  list("gameid= ?1 and isactive=true",gameId);
    }
}

package org.cana.services.gameplayer.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.cana.services.gameplayer.repository.daos.GamePlayer;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GamePlayerRepository implements PanacheRepository<GamePlayer>
{
    public List<GamePlayer> findByIdAndIsActive(Long playerId) {
        return  list("id= ?1 and isactive=true",playerId);
    }
}

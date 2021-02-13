package org.cana.services.game.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.cana.services.game.repository.daos.Games;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GameRepository implements PanacheRepository<Games> {

    public List<Games> findByIdAndStatusNotIn(Long gameId, List<String> skippedStatus) {
        return list("id = ?1 and status NOT IN (?2)", gameId, skippedStatus);
    }
}

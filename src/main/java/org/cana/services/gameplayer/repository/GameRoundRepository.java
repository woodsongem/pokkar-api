package org.cana.services.gameplayer.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.cana.services.gameplayer.repository.daos.GameRound;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameRoundRepository implements PanacheRepository<GameRound> {
}

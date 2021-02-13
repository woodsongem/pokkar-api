package org.cana.services.game.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.cana.services.game.repository.daos.Games;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameRepository implements PanacheRepository<Games> {

}

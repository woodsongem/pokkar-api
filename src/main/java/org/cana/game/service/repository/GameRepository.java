package org.cana.game.service.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.cana.game.service.repository.daos.Games;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameRepository implements PanacheRepository<Games> {

}

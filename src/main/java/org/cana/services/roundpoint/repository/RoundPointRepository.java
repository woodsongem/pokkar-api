package org.cana.services.roundpoint.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.cana.services.roundpoint.repository.daos.RoundPoint;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoundPointRepository implements PanacheRepository<RoundPoint> {
}

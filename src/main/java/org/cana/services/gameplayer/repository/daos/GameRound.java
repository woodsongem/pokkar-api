package org.cana.services.gameplayer.repository.daos;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class GameRound {
    @JMap
    @Id
    @GeneratedValue
    private Long id;
    @JMap
    private Long gameId;
    @JMap
    private Long gamePlayerId;
    @JMap
    private String createdBy;
    @JMap
    private Date createdOn;
    @JMap
    private String modifiedBy;
    @JMap
    private Date modifiedOn;
    @JMap
    private Boolean isActive;
}

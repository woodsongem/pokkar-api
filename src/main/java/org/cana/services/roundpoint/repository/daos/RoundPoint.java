package org.cana.services.roundpoint.repository.daos;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class RoundPoint {
    @JMap
    @Id
    @GeneratedValue
    private Long id;
    @JMap
    private Long roundId;
    @JMap
    private Long playerId;
    @JMap
    private Long point;
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

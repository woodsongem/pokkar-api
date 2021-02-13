package org.cana.services.game.repository.daos;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Games {
    @Id
    @GeneratedValue
    private Long id;
    @JMap
    private String name;
    @JMap
    private long userid;
    @JMap
    private String createdBy;
    @JMap
    private Date createdOn;
    @JMap
    private String modifiedBy;
    @JMap
    private Date modifiedOn;
    @JMap
    private String status;
}

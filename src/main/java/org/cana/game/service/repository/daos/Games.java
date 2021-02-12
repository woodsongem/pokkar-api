package org.cana.game.service.repository.daos;

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
    private String createdby;
    @JMap
    private Date createdon;
    @JMap
    private String modifiedby;
    @JMap
    private Date modifiedon;
    @JMap
    private String status;
}

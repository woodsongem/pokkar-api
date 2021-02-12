package org.cana.resources.gameplayer.models;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapAccessor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class GamePlayerModel
{
    @JMap
    private Long id;
    @JMap
    private Long gameId;
    @JMap
    private String name;
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

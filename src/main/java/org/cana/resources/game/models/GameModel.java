package org.cana.resources.game.models;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

@Data
public class GameModel {
    @JMap
    private Long id;
    @JMap
    private String name;
    @JMap
    private long userid;
    @JMap
    private String createdby;
    //    @JMap
//    private String createdon;
    @JMap
    private String modifiedby;
    //    @JMap
//    private String modifiedon;
    @JMap
    private String status;
}

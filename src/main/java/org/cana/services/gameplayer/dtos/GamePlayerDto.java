package org.cana.services.gameplayer.dtos;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;
import org.cana.dtos.BaseDto;

@Data
public class GamePlayerDto extends BaseDto {
    private Long id;
    private String gameId;
    @JMap
    private String name;
    private String userId;
    private Long parsedUserId;
    private Boolean isActive;
}

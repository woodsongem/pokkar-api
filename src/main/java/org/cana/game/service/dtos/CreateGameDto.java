package org.cana.game.service.dtos;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;
import org.cana.dtos.BaseDto;

@Data
public class CreateGameDto extends BaseDto {
    private Long id;
    @JMap
    private String name;
    @JMap
    private String userid;
    private Long parsedUserId;
    private String status;
}

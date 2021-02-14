package org.cana.resources.roundpoint.models;

import lombok.Data;
import org.cana.services.customvalidators.Point;
import org.cana.services.roundpoint.errorcodes.RoundPointErrorCodes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class RoundPointModel {
    @NotBlank(message = RoundPointErrorCodes.GamePointIsNull)
    @NotEmpty(message = RoundPointErrorCodes.GamePointIsEmpty)
    @Point(message = RoundPointErrorCodes.GamePointIsNotAllowedOne)
    private String point;
}

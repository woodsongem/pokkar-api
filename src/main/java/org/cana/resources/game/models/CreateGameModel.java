package org.cana.resources.game.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CreateGameModel {
    @NotBlank(message = "Pokkar.Api.{0}.{1}.GameName.IsNull")
    @NotEmpty(message = "Pokkar.Api.{0}.{1}.GameName.IsEmpty")
    private String name;

    private String userid;
}

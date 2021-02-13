package org.cana.resources.game.mappers;

import org.cana.resources.game.models.CreateGameModel;
import org.cana.resources.game.models.GameModel;
import org.cana.services.game.dtos.CreateGameDto;
import org.cana.services.game.repository.daos.Games;

public interface GameMapper {

    CreateGameDto mapCreateGameDto(CreateGameModel createGameModel);

    GameModel mapGameModel(Games games);
}

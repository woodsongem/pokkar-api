package org.cana.resources.game.mappers;

import org.cana.game.service.dtos.CreateGameDto;
import org.cana.game.service.repository.daos.Games;
import org.cana.resources.game.models.CreateGameModel;
import org.cana.resources.game.models.GameModel;

public interface GameMapper {

    CreateGameDto mapCreateGameDto(CreateGameModel createGameModel);

    GameModel mapGameModel(Games games);
}

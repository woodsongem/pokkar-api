package org.cana.services.roundpoint.verifiers;

import org.cana.dtos.ErrorMsgDto;
import org.cana.services.game.dtos.GameStatus;
import org.cana.services.game.repository.GameRepository;
import org.cana.services.gameplayer.repository.GamePlayerRepository;
import org.cana.services.gameplayer.repository.GameRoundRepository;
import org.cana.services.roundpoint.dtos.RoundPointDto;
import org.cana.services.roundpoint.errorcodes.RoundPointErrorCodes;
import org.cana.services.roundpoint.repository.RoundPointRepository;
import org.cana.services.utilities.PokkarServiceUtility;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class RoundPointVerifierImpl implements RoundPointVerifier {
    @Inject
    GameRepository gameRepository;

    @Inject
    GamePlayerRepository gamePlayerRepository;

    @Inject
    GameRoundRepository gameRoundRepository;

    @Inject
    RoundPointErrorCodes roundPointErrorCodes;


    @Override
    public List<ErrorMsgDto> verifyCreateRoundPoint(RoundPointDto roundPointDto) {
        List<ErrorMsgDto> groupErrors = new ArrayList<>();

        List<ErrorMsgDto> errors = isGameIdValid(roundPointDto);
        if (!errors.isEmpty()) {
            groupErrors.addAll(errors);
        }

        errors = isGamePlayerIdValid(roundPointDto);

        if (!errors.isEmpty()) {
            groupErrors.addAll(errors);
        }

        errors = isGameRoundIdValid(roundPointDto);

        if (!errors.isEmpty()) {
            groupErrors.addAll(errors);
        }
        return groupErrors;
    }

    @Override
    public List<ErrorMsgDto> isGameIdValid(RoundPointDto roundPointDto) {
        var skippedStatus = Arrays.asList(GameStatus.DELETED);
        var game = gameRepository.findByIdAndStatusNotIn(roundPointDto.getParsedGameId(), skippedStatus);
        if (game == null) {
            return PokkarServiceUtility.getErrorMessages(roundPointErrorCodes.getGetGameIdNotFound(), "game id not found");
        }
        return Collections.emptyList();
    }

    @Override
    public List<ErrorMsgDto> isGamePlayerIdValid(RoundPointDto roundPointDto) {
        var gamePlayer = gamePlayerRepository.findByIdAndIsActive(roundPointDto.getParsedPlayerId()).stream().findFirst();
        if (gamePlayer == null || gamePlayer.isEmpty()) {
            return PokkarServiceUtility.getErrorMessages(roundPointErrorCodes.getGamePlayerIdNotFound(), "game player id not found");
        }

        roundPointDto.setGamePlayer(gamePlayer.get());
        return Collections.emptyList();
    }

    @Override
    public List<ErrorMsgDto> isGameRoundIdValid(RoundPointDto roundPointDto) {
        var gameRound = gameRoundRepository.findByIdAndGameidAndGameplayerid(roundPointDto.getParsedRoundId(), roundPointDto.getParsedGameId(), roundPointDto.getParsedPlayerId());
        if (gameRound == null || gameRound.isEmpty()) {
            return PokkarServiceUtility.getErrorMessages(roundPointErrorCodes.getGameRoundIdNotFound(), "game round id not found");
        }

        roundPointDto.setGameRound(gameRound.get(0));
        return Collections.emptyList();
    }
}

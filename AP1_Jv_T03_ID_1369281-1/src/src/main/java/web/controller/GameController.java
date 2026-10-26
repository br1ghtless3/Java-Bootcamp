package web.controller;

import domain.model.Board;
import domain.model.Game;
import domain.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.mapper.BoardWebMapper;
import web.mapper.GameWebMapper;
import web.model.ErrorDto;
import web.model.GameDto;

import java.util.UUID;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<GameDto> makeMove(
            @PathVariable("id") UUID id,
            @RequestBody GameDto requestGameDto
    ) {
        Board userBoard = BoardWebMapper.toDomain(requestGameDto.getBoard());

        Game updatedGame = gameService.processTurn(id, userBoard);

        return ResponseEntity.ok(GameWebMapper.toDto(updatedGame));
    }

    @ExceptionHandler({IllegalArgumentException.class, IndexOutOfBoundsException.class})
    public ResponseEntity<ErrorDto> handleValidationError(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(ex.getMessage()));
    }
}
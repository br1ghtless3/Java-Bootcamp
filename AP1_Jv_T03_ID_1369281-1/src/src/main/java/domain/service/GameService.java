package domain.service;

import domain.model.Board;
import domain.model.Game;
import java.util.UUID;

public interface GameService {
    Board getNextMove(Board currentBoard);
    void validateBoard(Board previousBoard, Board currentBoard);
    boolean checkGameOver(Board board);
    Game processTurn(UUID id, Board currentBoard);

}

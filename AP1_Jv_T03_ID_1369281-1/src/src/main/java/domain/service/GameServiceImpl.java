package domain.service;

import datasource.repository.GameRepository;
import domain.model.Board;
import domain.model.Game;

import java.util.UUID;

public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        if (gameRepository == null) {
            throw new IllegalArgumentException("GameRepository не может быть пустым");
        }
        this.gameRepository = gameRepository;
    }

    @Override
    public Game processTurn(UUID id, Board userBoard) {
        if (id == null) {
            throw new IllegalArgumentException("UUID игры не может быть пустым");
        }
        if (userBoard == null) {
            throw new IllegalArgumentException("Игровое поле не может быть пустым");
        }

        Game currentGame = gameRepository.findById(id)
                .orElseGet(() -> new Game(id, new Board()));

        Board previousBoard = currentGame.getBoard();

        validateBoard(previousBoard, userBoard);

        if (checkGameOver(userBoard)) {
            Game finishedGame = new Game(id, userBoard);
            gameRepository.save(finishedGame);
            return finishedGame;
        }

        Board nextBoard = getNextMove(userBoard);
        Game updatedGame = new Game(id, nextBoard);

        gameRepository.save(updatedGame);

        return updatedGame;
    }

    @Override
    public void validateBoard(Board previousBoard, Board currentBoard) {
        if (previousBoard == null || currentBoard == null) {
            throw new IllegalArgumentException("Игровое поле не может быть пустым");
        }

        if (checkGameOver(previousBoard)) {
            throw new IllegalArgumentException("Игра уже завершена, ходы делать нельзя");
        }

        int playerMovesCount = 0;
        int aiMovesCount = 0;

        for (int r = 0; r < Board.SIZE; r++) {
            for (int c = 0; c < Board.SIZE; c++) {
                int prev = previousBoard.getCell(r, c);
                int curr = currentBoard.getCell(r, c);

                if (prev != Board.EMPTY && prev != curr) {
                    throw new IllegalArgumentException(
                            String.format("Предыдущий ход в клетке [%d, %d] был изменен или стерт", r, c)
                    );
                }

                if (prev == Board.EMPTY && curr != Board.EMPTY) {
                    if (curr == Board.PLAYER) {
                        playerMovesCount++;
                    } else if (curr == Board.COMPUTER) {
                        aiMovesCount++;
                    } else {
                        throw new IllegalArgumentException("Недопустимое значение в клетке: " + curr);
                    }
                }
            }
        }

        if (aiMovesCount > 0) {
            throw new IllegalArgumentException("Игрок не может ходить за ПК");
        }
        if (playerMovesCount == 0) {
            throw new IllegalArgumentException("Игрок не сделал ни одного хода");
        }
        if (playerMovesCount > 1) {
            throw new IllegalArgumentException("Игрок не может сделать более одного хода за раз");
        }
    }

    @Override
    public boolean checkGameOver(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Игровое поле не может быть пустым");
        }
        return checkWinner(board) != 0 || isBoardFull(board);
    }

    @Override
    public Board getNextMove(Board currentBoard) {
        if (currentBoard == null) {
            throw new IllegalArgumentException("Игровое поле не может быть пустым");
        }
        if (checkGameOver(currentBoard)) {
            return currentBoard.deepCopy();
        }

        Board bestBoard = currentBoard.deepCopy();
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int r = 0; r < Board.SIZE; r++) {
            for (int c = 0; c < Board.SIZE; c++) {
                if (currentBoard.isEmpty(r, c)) {
                    Board simulation = currentBoard.deepCopy();
                    simulation.setCell(r, c, Board.COMPUTER);

                    int score = minimax(simulation, 0, false);
                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = r;
                        bestCol = c;
                    }
                }
            }
        }

        if (bestRow != -1 && bestCol != -1) {
            bestBoard.setCell(bestRow, bestCol, Board.COMPUTER);
        }
        return bestBoard;
    }


    private int minimax(Board board, int depth, boolean isMaximizing) {
        int winner = checkWinner(board);
        if (winner == Board.COMPUTER) {
            return 10 - depth;
        }
        if (winner == Board.PLAYER) {
            return depth - 10;
        }
        if (isBoardFull(board)) {
            return 0;
        }

        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;
            for (int r = 0; r < Board.SIZE; r++) {
                for (int c = 0; c < Board.SIZE; c++) {
                    if (board.isEmpty(r, c)) {
                        board.setCell(r, c, Board.COMPUTER);
                        int eval = minimax(board, depth + 1, false);
                        board.setCell(r, c, Board.EMPTY);
                        maxEval = Math.max(maxEval, eval);
                    }
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int r = 0; r < Board.SIZE; r++) {
                for (int c = 0; c < Board.SIZE; c++) {
                    if (board.isEmpty(r, c)) {
                        board.setCell(r, c, Board.PLAYER);
                        int eval = minimax(board, depth + 1, true);
                        board.setCell(r, c, Board.EMPTY);
                        minEval = Math.min(minEval, eval);
                    }
                }
            }
            return minEval;
        }
    }

    private int checkWinner(Board board) {
        for (int i = 0; i < Board.SIZE; i++) {
            if (board.getCell(i, 0) != Board.EMPTY &&
                    board.getCell(i, 0) == board.getCell(i, 1) &&
                    board.getCell(i, 1) == board.getCell(i, 2)) {
                return board.getCell(i, 0);
            }
            if (board.getCell(0, i) != Board.EMPTY &&
                    board.getCell(0, i) == board.getCell(1, i) &&
                    board.getCell(1, i) == board.getCell(2, i)) {
                return board.getCell(0, i);
            }
        }

        if (board.getCell(0, 0) != Board.EMPTY &&
                board.getCell(0, 0) == board.getCell(1, 1) &&
                board.getCell(1, 1) == board.getCell(2, 2)) {
            return board.getCell(0, 0);
        }

        if (board.getCell(0, 2) != Board.EMPTY &&
                board.getCell(0, 2) == board.getCell(1, 1) &&
                board.getCell(1, 1) == board.getCell(2, 0)) {
            return board.getCell(0, 2);
        }

        return 0;
    }

    private boolean isBoardFull(Board board) {
        for (int r = 0; r < Board.SIZE; r++) {
            for (int c = 0; c < Board.SIZE; c++) {
                if (board.isEmpty(r, c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
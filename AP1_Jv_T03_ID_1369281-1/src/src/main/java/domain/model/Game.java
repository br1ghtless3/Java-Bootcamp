package domain.model;

import java.util.UUID;

public class Game {
    private UUID id;
    private Board board;

    public Game() {
        this(UUID.randomUUID(), new Board());
    }

    public Game(Board board) {
        this(UUID.randomUUID(), board);
    }

    public Game(UUID id, Board board) {
        if (id == null) {
            throw new IllegalArgumentException("UUID игры не может быть пустым");
        }
        if (board == null) {
            throw new IllegalArgumentException("Игровое поле не может быть пустым");
        }
        this.id = id;
        this.board = board;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("UUID игры не может быть пустым");
        }
        this.id = id;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Игровое поле не может быть пустым");
        }
        this.board = board;
    }
}
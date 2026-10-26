package datasource.model;

import java.util.UUID;

public class GameEntity {
    private UUID id;
    private BoardEntity board;

    public GameEntity(UUID id, BoardEntity board) {
        this.id = id;
        this.board = board;
    }

    public UUID getId() {
        return id;
    }

    public BoardEntity getBoard() {
        return board;
    }
}
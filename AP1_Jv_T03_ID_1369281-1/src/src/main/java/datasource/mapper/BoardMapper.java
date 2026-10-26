package datasource.mapper;

import datasource.model.BoardEntity;
import domain.model.Board;

public class BoardMapper {

    public static BoardEntity toEntity(Board board) {
        if (board == null) {
            return null;
        }
        return new BoardEntity(board.getMatrix());
    }

    public static Board toDomain(BoardEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Board(entity.getMatrix());
    }
}
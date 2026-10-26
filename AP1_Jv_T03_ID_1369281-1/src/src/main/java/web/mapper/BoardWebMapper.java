package web.mapper;

import domain.model.Board;
import web.model.BoardDto;

public class BoardWebMapper {

    public static BoardDto toDto(Board board) {
        if (board == null) {
            return null;
        }
        return new BoardDto(board.getMatrix());
    }

    public static Board toDomain(BoardDto dto) {
        if (dto == null || dto.getMatrix() == null) {
            throw new IllegalArgumentException("Игровое поле не может быть пустым");
        }
        return new Board(dto.getMatrix());
    }
}
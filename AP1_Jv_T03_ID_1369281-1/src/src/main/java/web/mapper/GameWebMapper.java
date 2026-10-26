package web.mapper;

import domain.model.Game;
import web.model.GameDto;

public class GameWebMapper {

    public static GameDto toDto(Game game) {
        if (game == null) {
            return null;
        }
        return new GameDto(
                game.getId(),
                BoardWebMapper.toDto(game.getBoard())
        );
    }

    public static Game toDomain(GameDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Тело запроса игры не может быть пустым");
        }
        return new Game(
                dto.getId(),
                BoardWebMapper.toDomain(dto.getBoard())
        );
    }
}
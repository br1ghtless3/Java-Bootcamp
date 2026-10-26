package datasource.mapper;

import datasource.model.GameEntity;
import domain.model.Game;

public class GameMapper {

    public static GameEntity toEntity(Game game) {
        if (game == null) {
            return null;
        }
        return new GameEntity(
                game.getId(),
                BoardMapper.toEntity(game.getBoard())
        );
    }

    public static Game toDomain(GameEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Game(
                entity.getId(),
                BoardMapper.toDomain(entity.getBoard())
        );
    }
}
package datasource.repository;

import datasource.model.GameEntity;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GameStorage {
    private final Map<UUID, GameEntity> games = new ConcurrentHashMap<>();

    public void save(GameEntity game) {
        if (game != null && game.getId() != null) {
            games.put(game.getId(), game);
        }
    }

    public Optional<GameEntity> findById(UUID id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(games.get(id));
    }
}
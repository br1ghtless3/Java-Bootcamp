package datasource.repository;

import datasource.mapper.GameMapper;
import datasource.model.GameEntity;
import domain.model.Game;

import java.util.Optional;
import java.util.UUID;

public class GameRepositoryImpl implements GameRepository {
    private final GameStorage storage;

    public GameRepositoryImpl(GameStorage storage) {
        if (storage == null) {
            throw new IllegalArgumentException("GameStorage не может быть null");
        }
        this.storage = storage;
    }

    @Override
    public void save(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Нельзя сохранить пустую игру");
        }
        GameEntity entity = GameMapper.toEntity(game);
        storage.save(entity);
    }

    @Override
    public Optional<Game> findById(UUID id) {
        if (id == null) {
            return Optional.empty();
        }
        return storage.findById(id)
                .map(GameMapper::toDomain);
    }
}
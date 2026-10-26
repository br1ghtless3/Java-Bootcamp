package di;

import datasource.repository.GameRepository;
import datasource.repository.GameRepositoryImpl;
import datasource.repository.GameStorage;
import domain.service.GameService;
import domain.service.GameServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GameStorage gameStorage() {
        return new GameStorage();
    }

    @Bean
    public GameRepository gameRepository(GameStorage storage) {
        return new GameRepositoryImpl(storage);
    }

    @Bean
    public GameService gameService(GameRepository repository) {
        return new GameServiceImpl(repository);
    }
}
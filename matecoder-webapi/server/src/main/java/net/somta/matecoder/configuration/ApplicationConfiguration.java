package net.somta.matecoder.configuration;

import net.somta.git.GitFactory;
import net.somta.git.GitFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public GitFactory gitFactory(){
        GitFactory gitFactory = new GitFactoryBuilder().build("baseUrl","GitContants.privateToken");
        return gitFactory;
    }

}

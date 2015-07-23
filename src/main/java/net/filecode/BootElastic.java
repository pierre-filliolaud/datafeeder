package net.filecode;

import java.util.List;

import net.filecode.model.Data;
import net.filecode.service.DataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class BootElastic implements CommandLineRunner {

    @Autowired
    private DataService dataService;

    private static final Logger logger = LoggerFactory.getLogger(BootElastic.class);

    private void addSomeDatas() {
        Data starWars = getFirstData();
        dataService.addData(starWars);

        Data princessBride = getSecondData();
        dataService.addData(princessBride);
    }

    private Data getSecondData() {
        Data secondData = new Data();
        secondData.setId("2");
        secondData.setDescription("The Princess Bride");
        return secondData;
    }

    private Data getFirstData() {
        Data firstData = new Data();
        firstData.setId("1");
        firstData.setDescription("Star Wars");
        return firstData;
    }

    public void run(String... args) throws Exception {
        addSomeDatas();
        // We indexed star wars and pricess bride to our data
        // listing in elastic search

        List<Data> starWarsNameQuery = dataService.getByDescription("Star Wars");
        logger.info("Content of star wars name query is {}", starWarsNameQuery);

        List<Data> brideQuery = dataService.getByDescription("The Princess Bride");
        logger.info("Content of princess bride name query is {}", brideQuery);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootElastic.class, args);
    }
}

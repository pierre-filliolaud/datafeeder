package net.filecode.datafeeder.dao;

import java.util.Map;

import net.filecode.datafeeder.model.Data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-context.xml")
public class DataRepositoryIntegrationTest {
    
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private DataRepository repository;

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        Map<Data, String> mapping = elasticsearchTemplate.getMapping(Data.class);
        System.out.println(mapping.toString());
    }

}

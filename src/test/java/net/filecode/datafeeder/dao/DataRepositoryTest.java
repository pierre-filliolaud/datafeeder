package net.filecode.datafeeder.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import net.filecode.datafeeder.model.Data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/springContext-test.xml")
public class DataRepositoryTest {
    
    @Resource
    private DataRepository repository;
    
    @Before
    public void emptyData(){
        repository.deleteAll();
    }
    
    @Test
    public void shouldIndexSingleDataEntity(){

        Data data = new Data();
        data.setId("123455");
        data.setDescription("Spring Data Elasticsearch Test Article");
        //Indexing using sampleArticleRepository
        repository.save(data);
        //lets try to search same record in elasticsearch
        Data indexedData = repository.findOne(data.getId());
        assertThat(indexedData,is(notNullValue()));
        assertThat(indexedData.getId(),is(data.getId()));
    }

}

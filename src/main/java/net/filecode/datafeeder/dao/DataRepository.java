package net.filecode.datafeeder.dao;

import java.util.List;

import net.filecode.datafeeder.model.Data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DataRepository extends ElasticsearchRepository<Data, String> {
    public List<Data> findByDescription(String description);
}

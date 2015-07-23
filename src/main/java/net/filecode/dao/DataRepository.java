package net.filecode.dao;

import java.util.List;

import net.filecode.model.Data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DataRepository extends ElasticsearchRepository<Data, Long> {
    public List<Data> findByDescription(String description);
}

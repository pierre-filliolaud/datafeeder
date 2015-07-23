package net.filecode.datafeeder.service;

import java.util.List;

import net.filecode.datafeeder.dao.DataRepository;
import net.filecode.datafeeder.model.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private DataRepository repository;

    public List<Data> getByDescription(String description) {
        return repository.findByDescription(description);
    }

    public void addData(Data data) {
        repository.save(data);
    }
}

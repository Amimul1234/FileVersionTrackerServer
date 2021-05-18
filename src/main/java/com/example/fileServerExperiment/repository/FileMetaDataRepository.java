package com.example.fileServerExperiment.repository;

import com.example.fileServerExperiment.entity.FileMetaData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMetaDataRepository extends MongoRepository<FileMetaData, String> {
}

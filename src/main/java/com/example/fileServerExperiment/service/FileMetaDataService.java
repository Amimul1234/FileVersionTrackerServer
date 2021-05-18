package com.example.fileServerExperiment.service;

import com.example.fileServerExperiment.entity.FileMetaData;
import com.example.fileServerExperiment.repository.FileMetaDataRepository;
import org.springframework.stereotype.Service;

@Service
public class FileMetaDataService {

    private final FileMetaDataRepository fileMetaDataRepository;

    public FileMetaDataService( FileMetaDataRepository fileMetaDataRepository ) {
        this.fileMetaDataRepository = fileMetaDataRepository;
    }

    public void saveFileMetaData( FileMetaData fileMetaData )
    {
        fileMetaDataRepository.save(fileMetaData);
    }
}

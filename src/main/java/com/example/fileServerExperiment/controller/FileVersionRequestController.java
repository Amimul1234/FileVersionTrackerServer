package com.example.fileServerExperiment.controller;

import com.example.fileServerExperiment.entity.ChunkTransporter;
import com.example.fileServerExperiment.entity.FileMetaData;
import com.example.fileServerExperiment.service.FileMetaDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/v1/fileVersion")
public class FileVersionRequestController {

    private final FileMetaDataService fileMetaDataService;

    public FileVersionRequestController( FileMetaDataService fileMetaDataService ) {
        this.fileMetaDataService = fileMetaDataService;
    }

    @PostMapping("/fileMetaDataReceiver")
    public void saveFileMetaData( @RequestBody FileMetaData fileMetaData)
    {
        try {
            fileMetaDataService.saveFileMetaData(fileMetaData);
        }catch (Exception e)
        {
            e.printStackTrace();
            //need to add chunk deleting mechanism
        }
    }

    @PostMapping("/fileChunkReceiver")
    public ResponseEntity<String> saveFileChunk( @RequestBody ChunkTransporter chunkTransporter )
    {

        try (OutputStream outputStream =
                     new FileOutputStream("FileChunks/" + chunkTransporter.getHashedName()))
        {
            outputStream.write(chunkTransporter.getChunk());
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(null);
        }
    }
}

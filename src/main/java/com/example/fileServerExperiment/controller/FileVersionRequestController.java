package com.example.fileServerExperiment.controller;

import com.example.fileServerExperiment.entity.ChunkTransporter;
import com.example.fileServerExperiment.entity.FileMetaData;
import com.example.fileServerExperiment.service.FileMetaDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/v1/fileVersion")
public class FileVersionRequestController {

    private final FileMetaDataService fileMetaDataService;
    private int i;

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
            //need to add chunk deleting mechanism
            e.printStackTrace();
        }
    }

    @PostMapping("/fileChunkReceiver")
    public void saveFileChunk( @RequestBody ChunkTransporter chunkTransporter)
    {
        i++;
        try (FileOutputStream fos = new FileOutputStream("C:/Users/Amimul/Desktop/FileChunks/" + i))
        {
            fos.write(chunkTransporter.getChunk());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

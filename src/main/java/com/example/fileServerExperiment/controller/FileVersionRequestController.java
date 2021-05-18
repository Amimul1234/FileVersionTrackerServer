package com.example.fileServerExperiment.controller;

import com.example.fileServerExperiment.entity.FileMetaData;
import com.example.fileServerExperiment.service.FileMetaDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController("/v1/fileVersion")
public class FileVersionRequestController {

    private final FileMetaDataService fileMetaDataService;

    public FileVersionRequestController( FileMetaDataService fileMetaDataService ) {
        this.fileMetaDataService = fileMetaDataService;
    }

    @PostMapping("/fileMetaDataReceiver")
    public void saveFileMetaData( @RequestBody FileMetaData fileMetaData)
    {
        //need to add chunk deleting mechanism
        fileMetaDataService.saveFileMetaData(fileMetaData);
    }

    @PostMapping("/fileChunkReceiver")
    public void saveFileChunk(@RequestParam("chunk") byte[] chunk,
                              @RequestParam("name") String hashedName)
    {
        try (OutputStream outputStream = new FileOutputStream("FileChunks/" + hashedName))
        {
            outputStream.write(chunk);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

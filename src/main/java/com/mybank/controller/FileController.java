package com.mybank.controller;

import com.mybank.dto.request.FileRequest;
import com.mybank.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public String saveFile(@RequestBody FileRequest content) throws IOException {
       return fileService.saveFile(content.getContent());
    }

}

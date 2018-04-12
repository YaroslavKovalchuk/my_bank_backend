package com.mybank.service.impl;

import com.mybank.dto.request.MyMiltipartFile;
import com.mybank.service.FileService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String saveFile(String content) throws IOException {
        String [] arr = content.split(",");
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] imgContent = base64Decoder.decodeBuffer(arr[1]);
        String expansion = arr[0].split("/")[1].split(";")[0];
        String name = UUID.randomUUID().toString();
        MyMiltipartFile myMiltipartFile = new MyMiltipartFile(imgContent,name,expansion);

        File file = new File("D:\\Java\\angular\\myBankwithAngular\\img\\" + name +"."+ expansion);
        myMiltipartFile.transferTo(file);
        file.createNewFile();

        return myMiltipartFile.getOriginalFilename();
    }
}

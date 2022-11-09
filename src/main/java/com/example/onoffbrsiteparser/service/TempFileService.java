package com.example.onoffbrsiteparser.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jsoup.Connection;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class TempFileService {

    public File createTempFile(Connection.Response response) {
        File file;
        try {
            file = File.createTempFile("onOffDailyFile", ".brDailyTemp");
            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(response.bodyStream(),outputStream);
//            System.out.println(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

//    File file = null;
//        try {
//        file = File.createTempFile("onOffDailyFile", ".brDailyTemp");
//        try (OutputStream outputStream = new FileOutputStream(file)){
//            IOUtils.copy(response.bodyStream(),outputStream);
//        }
//
////            files.add(file);
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    } finally {
//        file.deleteOnExit();
//    }
//
//        return file;
//}

}

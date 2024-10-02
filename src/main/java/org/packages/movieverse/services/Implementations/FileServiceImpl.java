package org.packages.movieverse.services.Implementations;

import org.packages.movieverse.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        //get name of the file
        String fileName = file.getOriginalFilename();

        //get the file path
        String filePath = path + File.separator + fileName;
        //File.separator ensures that path and fileName should be appended

        //create a file object
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        //copy the file or upload the file to the path
        Files.copy(file.getInputStream(), Paths.get(filePath));

        //StandardCopyOption.REPLACE_EXISTING is used because if same file name exits
        //it will replace previous one by the new one
        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String filename) throws IOException {
        String filePath = path + File.separator + filename;
        return new FileInputStream(filePath);
    }
}

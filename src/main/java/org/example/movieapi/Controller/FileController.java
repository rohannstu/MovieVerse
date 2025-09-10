package org.example.movieapi.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.movieapi.Service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController //Marks this class as a REST API controller (Spring automatically serializes responses as JSON or text)
@RequestMapping("/file/") //All APIs here will start with /file/. Example: http://localhost:8080/file/upload.
@CrossOrigin(origins = "*")//Enables CORS so frontend apps (Angular/React/etc.) from any domain can access your endpoints.
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    //Dependency Injection:
    //FileService is injected into the controller
    //Because FileServiceImpl is annotated with @Service, Spring automatically wires it here.

    @Value("${project.poster}") //Reads a property project.poster from application.yml
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFileHandler(@RequestPart MultipartFile file) throws IOException {
        String uploadedFileName = fileService.uploadFile(path, file);
        return ResponseEntity.ok("File uploaded : " + uploadedFileName);
    }

    @GetMapping(value = "/{fileName}")
    public void serveFileHandler(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        InputStream resourceFile = fileService.getResourceFile(path, fileName);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(resourceFile, response.getOutputStream());
    }
}
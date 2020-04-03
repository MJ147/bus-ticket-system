package pl.connectis.programator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.connectis.programator.util.DataGenerator;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    DataGenerator dataGenerator;

    public DataController(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
        dataGenerator.createData();
        dataGenerator.printAllData();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> fileUpload(@RequestParam(name = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.ok("File is empty, please select proper file.");
        }

        try {
            saveUploadedFiles(Arrays.asList(file));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("File is uploaded.");
    }

    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\projekty\\hard\\" + file.getOriginalFilename());
            Files.write(path, bytes);
        }
    }

}

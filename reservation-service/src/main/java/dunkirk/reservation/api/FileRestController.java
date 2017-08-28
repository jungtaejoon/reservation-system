package dunkirk.reservation.api;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dunkirk.reservation.service.FileService;

@RestController
@RequestMapping("/files")
public class FileRestController {
    private FileService fileService;

    @Autowired
    public FileRestController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{id:[\\d]+}")
    public FileSystemResource test(@PathVariable int id) {
        File file = new File(fileService.getSaveFileName(id));
        if (!file.exists()) {
            throw new RuntimeException("file not found");
        } else {
            return new FileSystemResource(file);
        }
    }
}

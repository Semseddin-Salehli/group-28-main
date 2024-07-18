package az.developia.course.qrup28.web.rest;

import az.developia.course.qrup28.dto.request.FileRequest;
import az.developia.course.qrup28.dto.response.FileResponse;
import az.developia.course.qrup28.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @SneakyThrows
    @PostMapping
    public FileResponse createUser(@RequestPart FileRequest fileRequest , @RequestPart("img") MultipartFile file) {
        return fileService.createUser(fileRequest , file);
    }
}

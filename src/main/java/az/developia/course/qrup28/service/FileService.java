package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.request.FileRequest;
import az.developia.course.qrup28.dto.response.FileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    FileResponse createUser(FileRequest fileRequest , MultipartFile file) throws IOException;
}

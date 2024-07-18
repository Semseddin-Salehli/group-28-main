package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.FileRequest;
import az.developia.course.qrup28.dto.response.FileResponse;
import az.developia.course.qrup28.model.File;
import az.developia.course.qrup28.repository.FileRepository;
import az.developia.course.qrup28.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Value(value = "${file.location}")
    private String folderLocation;

    @Override
    public FileResponse createUser(FileRequest fileRequest, MultipartFile file) {

        Path path = Paths.get(folderLocation + file.getOriginalFilename());

        String img = "";
        if(!Files.exists(path)) {
            Path path1 = null;
            try {
                path1 = Files.createFile(path);
                img = Files.write(path1, file.getBytes(), StandardOpenOption.APPEND).toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            img = path.toString();
        }


        File dbFile = fileRepository.save(File.builder()
                .name(fileRequest.getName())
                .surname(fileRequest.getSurname())
                .imagePath(img).build());

        return FileResponse.builder()
                .id(dbFile.getId())
                .name(dbFile.getName())
                .surname(dbFile.getSurname())
                .imagePath(dbFile.getImagePath())
                .build();
    }
}

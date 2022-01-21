package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.SchoolClassRequest;
import az.developia.course.qrup28.dto.response.SchoolClassResponse;
import az.developia.course.qrup28.exception.ClassNotFoundException;
import az.developia.course.qrup28.model.SchoolClass;
import az.developia.course.qrup28.repository.SchoolClassRepository;
import az.developia.course.qrup28.service.SchoolClassService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService {

    private final SchoolClassRepository classRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<SchoolClassResponse> getAll() {
        return classRepository.findAll().stream()
                .map(schoolClass -> modelMapper.map(schoolClass , SchoolClassResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public SchoolClassResponse getById(Long id) {
        SchoolClass schoolClass = classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException("Bele bir sinif tapilmadi"));
        return  modelMapper.map(schoolClass, SchoolClassResponse.class);
    }

    @Override
    public Long add(SchoolClassRequest request) {
        SchoolClass schoolClass = modelMapper.map(request, SchoolClass.class);
        return classRepository.save(schoolClass).getId();
    }

    @Override
    public SchoolClassResponse update(Long id, SchoolClassRequest request) {
        SchoolClass dbClass = classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException("Bele bir sinif tapilmadi"));

        SchoolClass newClass = modelMapper.map(request , SchoolClass.class);

        newClass.setId(id);
        modelMapper.map(newClass, dbClass);

        return modelMapper.map(classRepository.save(dbClass) , SchoolClassResponse.class);
    }

    @Override
    public Long delete(Long id) {
        SchoolClass schoolClass = classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException("Bele bir sinif tapilmadi"));

        classRepository.delete(schoolClass);
        return id;
    }
}

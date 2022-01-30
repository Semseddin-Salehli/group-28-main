package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.request.SchoolClassRequest;
import az.developia.course.qrup28.dto.response.SchoolClassResponse;

import java.util.List;

public interface SchoolClassService {
    List<SchoolClassResponse> getAll();

    SchoolClassResponse getById(Long id);

    Long add(SchoolClassRequest request);

    SchoolClassResponse update(Long id, SchoolClassRequest request);

    Long delete(Long id);
}

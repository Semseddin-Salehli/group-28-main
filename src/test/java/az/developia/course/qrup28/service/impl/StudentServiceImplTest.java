package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.SeriesRequest;
import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.dto.response.SchoolClassResponse;
import az.developia.course.qrup28.dto.response.StudentResponse;
import az.developia.course.qrup28.model.SchoolClass;
import az.developia.course.qrup28.model.Series;
import az.developia.course.qrup28.model.Student;
import az.developia.course.qrup28.repository.SchoolClassRepository;
import az.developia.course.qrup28.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    StudentRepository studentRepository;

    @Mock
    ModelMapper modelMapper;

    @Mock
    SchoolClassRepository classRepository;

    @InjectMocks
    StudentServiceImpl studentService;

    private Student dbData;
    private Student newStudent;
    private StudentResponse expectedResponse;
    private StudentRequest studentRequest;
    private Series series;
    private SeriesRequest seriesRequest;
    private final Long standardId = 34L;

    @BeforeEach
    void setUp() {
        seriesRequest = new SeriesRequest();
        seriesRequest.setCode("qwerty");
        series = new Series();
        series.setId(2L);
        series.setCode("qwerty");

        expectedResponse = new StudentResponse();
        expectedResponse.setId(34L);
        expectedResponse.setName("Unknown");
        expectedResponse.setAddress("Baku");
        expectedResponse.setSchoolClass(new SchoolClassResponse(1l, "10B"));

        dbData = new Student();
        dbData.setId(34L);
        dbData.setPhone("+99455667788");
        dbData.setName("Unknown");
        dbData.setAddress("Baku");
        dbData.setSeries(series);
        dbData.setSchoolClass(new SchoolClass(1L, "10B", null));

        newStudent = new Student();
        newStudent.setId(34L);
        newStudent.setPhone("+99455667788");
        newStudent.setName("Unknown");
        newStudent.setAddress("Baku");
        newStudent.setSeries(series);
        newStudent.setSchoolClass(new SchoolClass(1L, "10B", null));
        studentRequest = new StudentRequest();
        studentRequest.setName("Mahammad");
        studentRequest.setSchoolClassId(1L);
        studentRequest.setAddress("Baku");
        studentRequest.setSeries(seriesRequest);
    }

    @Test
    void givenNothingThenReturnEverythingSuccessfully() {
        //Arrange
        when(studentRepository.findAll()).thenReturn(Collections.singletonList(dbData));
        when(modelMapper.map(any(), any())).thenReturn(expectedResponse);
        // Act
        List<StudentResponse> students = studentService.getAll();
        //Assert
        assertEquals(expectedResponse.getId(), students.get(0).getId());
        assertEquals(expectedResponse.getSchoolClass().getId(), students.get(0).getSchoolClass().getId());
        assertEquals(expectedResponse.getAddress(), students.get(0).getAddress());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void givenStudentWhenIdMustBeGreaterThanZero() {
        //Arrange
        when(studentRepository.findById(standardId)).thenReturn(Optional.of(dbData));
        when(modelMapper.map(any(), any())).thenReturn(expectedResponse);
        //Act
        StudentResponse givenData = studentService.getById(standardId);
        //Assert
        assertEquals(expectedResponse.getId(), standardId);
        assertEquals(expectedResponse.getAddress(), givenData.getAddress());
        verify(studentRepository, times(1)).findById(standardId);
        verify(modelMapper, times(1)).map(any(), any());
    }

    @Test
    void whenDeleteStudentWithIdThanEqualExpectedData() {
        //Arrange
        when(studentRepository.findById(standardId)).thenReturn(Optional.of(dbData));
        when(modelMapper.map(any(), any())).thenReturn(expectedResponse);
        //Act
        StudentResponse deletedStudent = studentService.delete(standardId);
        //Assert
        assertEquals(expectedResponse.getId(), deletedStudent.getId());
        assertEquals(expectedResponse.getSchoolClass().getId(), deletedStudent.getSchoolClass().getId());
        verify(studentRepository, times(1)).findById(standardId);
        verify(studentRepository, times(1)).delete(any());
        verify(modelMapper, times(1)).map(any(), any());
    }

    @Test
    void givenRequestDataEqualDataBaseDataWhenUpdateTime() {
        //Arrange
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setId(1l);
        doNothing().when(modelMapper).map(studentRequest.getSeries(), series);
        when(studentRepository.findById(standardId)).thenReturn(Optional.of(dbData));
        when(modelMapper.map(studentRepository.save(newStudent), StudentResponse.class)).thenReturn(expectedResponse);
        when(classRepository.findById(1L)).thenReturn(Optional.of(schoolClass));
        //Act
        StudentResponse changedStudent = studentService.update(studentRequest, standardId);
        //Assert
        assertEquals(changedStudent.getId(), standardId);
        assertEquals(changedStudent.getSchoolClass().getId(), studentRequest.getSchoolClassId());
        assertEquals(changedStudent.getAddress(), studentRequest.getAddress());
        //assertEquals(changedStudent.getSeries().getId(),dbData.getSeries().getId());
        verify(studentRepository, times(1)).findById(standardId);
        verify(studentRepository, times(1)).save(newStudent);
        verify(classRepository, times(1)).findById(1L);
        verify(modelMapper, times(1)).map(any(), any());

    }
}
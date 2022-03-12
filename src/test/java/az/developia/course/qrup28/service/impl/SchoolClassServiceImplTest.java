package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.response.SchoolClassResponse;
import az.developia.course.qrup28.model.SchoolClass;
import az.developia.course.qrup28.repository.SchoolClassRepository;
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

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SchoolClassServiceImplTest {

    @Mock
    SchoolClassRepository classRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    SchoolClassServiceImpl schoolClassService;

    private SchoolClass schoolClass;
    private SchoolClassResponse schoolClassResponse;

    @BeforeEach
    public void setUp() {
        schoolClass = new SchoolClass();
        schoolClass.setId(1L);
        schoolClass.setName("10C");

        schoolClassResponse = new SchoolClassResponse();
        schoolClassResponse.setId(1L);
        schoolClassResponse.setName("10C");
    }


    @Test
    public void givenSchoolClassResponseThenEverythingSuccessfully() {
        //Arrange
        when(modelMapper.map(any(), any()))
                .thenReturn(schoolClassResponse);

        List<SchoolClass> dbData = Collections.singletonList(schoolClass);
        when(classRepository.findAll()).thenReturn(dbData);

        //Act
        List<SchoolClassResponse> getAll = schoolClassService.getAll();

        //Assert
        assertThat(getAll.get(0).getId()).isEqualTo(dbData.get(0).getId());
        verify(classRepository, times(1)).findAll();
    }

    @Test
    public void givenSchoolClassResponseThenExternalIdThanGreaterZero() {
        //Arrange
        Long testId = 1L;
        when(modelMapper.map(any(), any()))
                .thenReturn(schoolClassResponse);
        when(classRepository.findById(testId)).thenReturn(Optional.of(schoolClass));
        //Act
        SchoolClassResponse response = schoolClassService.getById(testId);

        //Assert
        assertThat(response.getId()).isEqualTo(testId);
        assertThat(response.getName()).isEqualTo(schoolClass.getName());
        verify(classRepository, times(1)).findById(testId);
    }
}
package com.example.jobagapi;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.service.PostulantService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import com.example.jobagapi.service.EmployeerServiceImpl;
import com.example.jobagapi.service.PostulantServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostulantServiceImplTest {
    @Mock
    private PostulantRepository postulantRepository;

    @InjectMocks
    private PostulantServiceImpl postulantService;

    @Test
    void findByIdTest() throws Exception {
        Long id = 1L;

        Postulant postulant = new Postulant(1L,"firstname","lastname","email",123L,"password","document","posicion");

        given(postulantRepository.findById(id)).willReturn(Optional.of(postulant));

        Postulant expected = postulantService.getPostulantById(id);

        Assertions.assertThat(expected).isNotNull();
    }

    @Test
    void findAllTest() throws Exception {

        Long id = 1L;

        Postulant postulant = new Postulant(1L,"firstname","lastname","email",123L,"password","document","posicion");

        List<Postulant> postulants = new ArrayList<>();
        postulants.add(postulant);

        given(postulantRepository.findAll()).willReturn(postulants);

        List<Postulant> expected = postulantRepository.findAll();
        assertEquals(expected, postulants);
    }

}

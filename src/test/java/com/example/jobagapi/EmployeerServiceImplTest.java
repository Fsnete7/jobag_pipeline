package com.example.jobagapi;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.service.EmployeerServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeerServiceImplTest {

    @Mock
    private EmployeerRepository employeerRepository;

    @InjectMocks
    private EmployeerServiceImpl employeerService;

    @Test
    void findByIdTest() throws Exception {
        Long id = 1L;

        Employeer employeer = new Employeer(1L,"firstname","lastname","email",123L,"password","document","posicion");

        given(employeerRepository.findById(id)).willReturn(Optional.of(employeer));

        Employeer expected = employeerService.getEmployeerById(id);

        assertThat(expected).isNotNull();
    }

    @Test
    void findAllTest() throws Exception {

        Long id = 1L;

        Employeer employeer = new Employeer(1L,"firstname","lastname","email",123L,"password","document","posicion");

        List<Employeer> employeers = new ArrayList<>();
        employeers.add(employeer);

        given(employeerRepository.findAll()).willReturn(employeers);

        List<Employeer> expected = employeerRepository.findAll();
        assertEquals(expected, employeers);
    }



}
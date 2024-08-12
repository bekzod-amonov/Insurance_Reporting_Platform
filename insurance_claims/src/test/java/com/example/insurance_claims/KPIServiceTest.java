package com.example.insurance_claims;

import com.example.insurance_claims.model.KPIResult;
import com.example.insurance_claims.service.KPIService;
import com.example.insurance_claims.repository.KPIResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class KPIServiceTest {

    @Mock
    private KPIResultRepository kpiResultRepository;

    @InjectMocks
    private KPIService kpiService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllKPIResults() {
        KPIResult kpi1 = new KPIResult();
        kpi1.setPolicyId(1L);
        kpi1.setPvfp(new BigDecimal("100.00"));
        kpi1.setVnb(new BigDecimal("200.00"));
        kpi1.setScr(new BigDecimal("300.00"));

        KPIResult kpi2 = new KPIResult();
        kpi2.setPolicyId(2L);
        kpi2.setPvfp(new BigDecimal("110.00"));
        kpi2.setVnb(new BigDecimal("210.00"));
        kpi2.setScr(new BigDecimal("310.00"));

        List<KPIResult> kpiResults = Arrays.asList(kpi1, kpi2);

        when(kpiResultRepository.findAll()).thenReturn(kpiResults);

        List<KPIResult> result = kpiService.getAllKPIResults();
        assertEquals(2, result.size());
        assertEquals(kpi1, result.get(0));
        assertEquals(kpi2, result.get(1));
    }

    @Test
    public void testGetKPIResultByPolicyId() {
        KPIResult kpi = new KPIResult();
        kpi.setPolicyId(1L);
        kpi.setPvfp(new BigDecimal("100.00"));
        kpi.setVnb(new BigDecimal("200.00"));
        kpi.setScr(new BigDecimal("300.00"));

        when(kpiResultRepository.findById(1L)).thenReturn(Optional.of(kpi));

        KPIResult result = kpiService.getKPIResultByPolicyId(1L);
        assertEquals(kpi, result);
    }

    @Test
    public void testGetKPIResultByPolicyId_NotFound() {
        when(kpiResultRepository.findById(1L)).thenReturn(Optional.empty());

        KPIResult result = kpiService.getKPIResultByPolicyId(1L);
        assertEquals(null, result);
    }
}

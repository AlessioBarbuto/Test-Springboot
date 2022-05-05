package com.intesasanpaolo.bear.tit0.engine.service.controlli;


import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.WtInputCtrlDTO;
import com.intesasanpaolo.bear.tit0.engine.service.impl.DtCtrlParamService;
import com.intesasanpaolo.bear.tit0.engine.service.impl.WtCtrlInputAnagService;
import org.dozer.Mapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


class ListInputServiceTest extends BaseTest {

    @Autowired
    private ListInputService listInputService;

    @Mock
    private WtCtrlInputAnagService wtCtrlInputAnagService;

    @Mock
    private DtCtrlParamService dtCtrlParamService;

    @Mock
    private Mapper mapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void bearLogger() {
    }

    @Test
    void run() {
        String controlloId = "controlloId";
        listInputService.run(controlloId);
        assert(true);
    }

    @Test
    void getSogliaList(){
        WtInputCtrlDTO wtInputCtrlDTO = new WtInputCtrlDTO();
        wtInputCtrlDTO.setIdCtrl("123");
        wtInputCtrlDTO.setCodAsset("codAsset");
        List<WtInputCtrlDTO> wtInputCtrlListPerSource = new ArrayList<>();
        wtInputCtrlListPerSource.add(wtInputCtrlDTO);
        listInputService.getSogliaList(wtInputCtrlListPerSource);
    }

    @Test
    void getCurvaList(){
        List<WtInputCtrlDTO> wtInputCtrlListPerSource = new ArrayList<>();
     listInputService.getCurvaList(wtInputCtrlListPerSource);
    }
}
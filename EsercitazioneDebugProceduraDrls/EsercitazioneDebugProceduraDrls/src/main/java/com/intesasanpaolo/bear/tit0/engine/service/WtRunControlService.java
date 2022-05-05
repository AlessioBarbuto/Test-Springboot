package com.intesasanpaolo.bear.tit0.engine.service;

import com.intesasanpaolo.bear.tit0.engine.dto.WtRunCtrlDTO;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtRunCtrl;

public interface WtRunControlService {

  Void run(WtRunCtrlDTO wtRunCtrl);

  WtRunCtrl findWtRunCtrlByIdRun(String idRun);
}

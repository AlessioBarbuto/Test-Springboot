package com.intesasanpaolo.bear.tit0.engine.command;

import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.tit0.engine.dto.WtRunCtrlDTO;
import com.intesasanpaolo.bear.tit0.engine.service.WtRunControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SaveWtRunControlCommand extends BaseCommand<Void> {

  private final WtRunCtrlDTO wtRunCtrl;

  @Autowired private WtRunControlService wtRunControlService;

  public SaveWtRunControlCommand(WtRunCtrlDTO wtRunCtrl) {
    this.wtRunCtrl = wtRunCtrl;
  }

  @Override
  public Void execute() throws Exception {
    return wtRunControlService.run(wtRunCtrl);
  }
}

package com.intesasanpaolo.bear.tit0.engine.command;

import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.tit0.engine.dto.HistoryDTO;
import com.intesasanpaolo.bear.tit0.engine.service.SaveHistoryControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SaveHistoryControlCommand extends BaseCommand<Void> {

  private final HistoryDTO history;

  @Autowired private SaveHistoryControlService saveHistoryControlService;

  public SaveHistoryControlCommand(HistoryDTO history) {
    this.history = history;
  }

  @Override
  public Void execute() throws Exception {
    return saveHistoryControlService.run(history);
  }
}

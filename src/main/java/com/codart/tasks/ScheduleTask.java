package com.codart.tasks;

import java.util.List;
import java.util.ArrayList;
import com.codart.utils.Utils;
import java.util.logging.Level;
import com.codart.model.Account;
import java.util.logging.Logger;
import com.codart.model.AccountDTO;
import com.codart.service.RevenueService;
import com.codart.SynchronizerApplication;
import com.codart.service.CsvWriteService;
import com.codart.service.CsvReaderService;

/**
 *
 * @author Robson
 * habilitar as anotações para agendamento de tasks
 */
//@Component
//@EnableAsync
public class ScheduleTask {

    CsvReaderService readerService = new CsvReaderService();
    CsvWriteService writeService = new CsvWriteService();
    RevenueService revenueService = new RevenueService();
    List<AccountDTO> accountsDTO = new ArrayList<>();
    AccountDTO accountDTO = new AccountDTO();
    List<Account> accounts = new ArrayList<>();
    Boolean updated = false;

    /**
     * 
     * habilitar esse trecho caso seja preciso agendar uma task, modificando
     * os parametros de execução @Scheduled(params...)
     * 
     * @Async
     *  @Scheduled(fixedDelay = 30000)
     *  public void execute() {
     *      start();
     *  }
     * 
     */
    
    public void start(String path) {
        accounts = readerService.read(path);
        accounts.forEach(account -> {
            try {
                updated = revenueService.updateAccount(account);
                if (updated) {
                    accountDTO = new AccountDTO(
                            account.getAgency(), Utils.maskFormater(account.getAccount()),
                            account.getBalance(), account.getStatus(), "SIM");
                    accountsDTO.add(accountDTO);
                    writeService.write(accountsDTO);
                }
            } catch (RuntimeException | InterruptedException ex) {
                Logger.getLogger(SynchronizerApplication.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
        System.out.println("############## processamento concluído ##############");
    }

}

package com.codart.service;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.codart.utils.Utils;
import java.util.logging.Level;
import com.codart.model.Account;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
public class CsvReaderService {

    public List<Account> read(String path) {
        List<Account> accounts = null;
        try {
            accounts = Files.lines(Paths.get(path))
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(col -> populate(col))
                    .collect(Collectors.toList());
            return accounts;
        } catch (IOException ex) {
            Logger.getLogger(CsvReaderService.class.getName())
                    .log(Level.WARNING, ex.getMessage());
        }
        return accounts;
    }

    private Account populate(String[] col) {
        return new Account(col[0], Utils.formatAccount(col[1]),
                Utils.formatBalance(col[2]), col[3]);
    }

}

package com.codart.service;

import java.util.List;
import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;
import com.codart.model.AccountDTO;
import com.opencsv.bean.StatefulBeanToCsv;
import org.springframework.stereotype.Service;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 *
 * @author Robson
 */
@Service
public class CsvWriteService {

    private String path = "C:/Users/document/filename.csv";
    
    public void write(List<AccountDTO> accounts) {
        try ( Writer writer = new FileWriter(path)) {
            StatefulBeanToCsv<AccountDTO> beanToCsv = 
                    new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(';')
                    .withApplyQuotesToAll(false)
                    .build();
            beanToCsv.write(accounts);
        } catch (IOException | CsvDataTypeMismatchException
                | CsvRequiredFieldEmptyException ex) {
            ex.getStackTrace();
        }

    }
 
}

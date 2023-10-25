/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.model.Pessoa;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Aplicacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        List<Pessoa> pessoas = new ArrayList<>();
        
       String[] cabecalho = {"nome", "idade", "telefone"};
        

        pessoas.add(new Pessoa("Bruno", 23, (float) 1.81));
        pessoas.add(new Pessoa("Oscar", 56, (float) 1.65));
        pessoas.add(new Pessoa("Caio", 15, (float) 1.97));
        
        List<String[]> linhas = new ArrayList<>();
        
        
        linhas.add(new String[]{"Joao","35","joao@dicasdejava.com.br"});
        linhas.add(new String[]{"Maria","23","maria@dicasdeprogramacao.com.br"});
        linhas.add(new String[]{"Ana","25","ana@dicasdejava.com.br"});
        for (Pessoa p : pessoas) {
            System.out.println(p.getNome() + " " + p.getIdade() + " " + p.getAltura());
        }
        
        try {
            Writer writer = Files.newBufferedWriter(Paths.get("Pessoas.csv"));
            CSVWriter csvWriter = new CSVWriter(writer);
            csvWriter.writeNext(cabecalho);
            csvWriter.writeAll(linhas);
            writer.flush();
            writer.close();

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}

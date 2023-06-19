package feljac.tech.plantumlconverter.service;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ConvertService {

    /**
     * @param text Converts text to SVG in string format
     * @return SVG as String
     */

    public String convertFromText(String text){
        if(checkIfTextStartsWithHyphen(text)){
           text = removeHyphen(text);
        }

        if(checkIfContainsAtSign(text)){
           text = addAtSign(text);
        }

        SourceStringReader sourceStringReader = new SourceStringReader(text);
        ByteArrayOutputStream bis = new ByteArrayOutputStream();

        try {
            sourceStringReader.outputImage(bis, new FileFormatOption(FileFormat.SVG));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bis.toString(StandardCharsets.UTF_8);
    }

    private String addAtSign(String text) {
        String[] rows = text.split("\n");

        if(!rows[0].startsWith("@startyaml")){
            rows[0] = "@startyaml" + rows[0];
        }

        if(!rows[rows.length -1].startsWith("@endyaml")){
            rows[rows.length -1 ] = "@endyaml" + rows[rows.length - 1];
        }

        StringBuilder sb = new StringBuilder();
        for(String row : rows){
            sb
            .append(row)
            .append("\n");
        }
        return sb.toString();
    }

    private boolean checkIfContainsAtSign(String text){
        String [] rows = text.split("\n");
        String lastRow = rows[rows.length - 1];
        return !text.startsWith("@startyaml") || !lastRow.startsWith("@endyaml");
    }

    private boolean checkIfTextStartsWithHyphen(String text){
        return text.startsWith("---");
    }

    private String removeHyphen(String text) {
        if(text.startsWith("---")){
            System.out.println("Removed --- from " + text);
            return text.substring(3);
        }
        return text;
    }
}

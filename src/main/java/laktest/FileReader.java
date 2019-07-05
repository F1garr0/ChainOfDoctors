package laktest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

class FileReader {
    static String readFile(String fileName)
    {
        BufferedReader br = new BufferedReader( new InputStreamReader( Class.class.getResourceAsStream("/resources/"+fileName+".json") ));
        return br.lines().collect(Collectors.joining(System.lineSeparator()));
    }

}

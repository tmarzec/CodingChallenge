import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    // retrieves JSON object from file
    private static JsonNode getJsonObject(String name) throws IOException {
        File f = new File(name);
        // parse f
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(f);
        return node;
    }
    // returns flattened JSON as string
    public static String getResult(String name) {
        JsonNode jn = null;
        try {
            jn = getJsonObject(name);
        }
        catch (FileNotFoundException fe) {
            System.err.println("Specified file " + name + " does not exist");
            System.exit(1);
        }
        catch (IOException io) {
            System.err.println("Error while parsing file " + name);
            System.exit(1);
        }
        Flattener flattener = new Flattener();
        String contents = null;
        try {
            contents = flattener.getFlattened(jn);
        } catch (JsonProcessingException e) {
            System.err.println("Error processing JsonNode");
            System.exit(1);
        }
        return contents;
    }

    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("Provide file name as first parameter");
            System.exit(1);
        }

        String result = getResult(args[0]);
        System.out.println(result);

    }
}

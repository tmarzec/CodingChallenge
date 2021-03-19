import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Iterator;
import java.util.Map;

public class Flattener {
    ObjectMapper mapper = new ObjectMapper();
    ObjectNode builder;

    private void getFlattened(JsonNode node, String prefix) {
        if(!node.fields().hasNext()) {
            // node has no children, it must be a value
            // prefix contains its name
            // assign value node to field with name prefix
            builder.set(prefix, node);
            return;
        }
        // iterate over children
        for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> curr = it.next();
            String name = curr.getKey();
            JsonNode child = curr.getValue();
            // recursively call with updated prefix
            if(prefix.equals("")) {
                getFlattened(child, name);
            }
            else {
                getFlattened(child, prefix + "." + name);
            }
        }
    }

    public String getFlattened(JsonNode node) throws JsonProcessingException {
        builder = mapper.createObjectNode();
        getFlattened(node, "");
        // ^ now builder stores flattened json
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(builder);
    }
}

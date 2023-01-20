import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ServerResponse {

    public static List<CatsFacts> serverResponse(String jsonString) throws IOException {
        CatsFacts[] catsFacts = ServerResponse.parseJson2(jsonString);
        return Arrays.stream(catsFacts).filter(catFact -> catFact.upvotes != null && catFact.upvotes != 0).toList();
    }

    private static CatsFacts[] parseJson2(String value) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(value, CatsFacts[].class);
    }

}



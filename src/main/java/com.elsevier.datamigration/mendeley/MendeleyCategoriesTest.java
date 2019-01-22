package com.elsevier.datamigration.mendeley;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class MendeleyCategoriesTest {

    @Test
    public void canDeserializeMendeleyJson() throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("./src/main/resources/mendeley_dataset.json"), Charset.defaultCharset());
        String jsonBlob = "";
        for (String s : lines) {
            jsonBlob += s;
        }
        ObjectMapper mapper = new ObjectMapper();
        MendeleyDataset dataset = mapper.readValue(jsonBlob, MendeleyDataset.class);
    }

}
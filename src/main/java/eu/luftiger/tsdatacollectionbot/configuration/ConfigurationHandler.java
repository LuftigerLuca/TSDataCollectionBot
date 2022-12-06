package eu.luftiger.tsdatacollectionbot.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import eu.luftiger.tsdatacollectionbot.TSDataCollectionBot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Handles the configuration of the bot
 */
public class ConfigurationHandler {

    private final TSDataCollectionBot bot;
    private final ObjectMapper objectMapper;

    private Configuration configuration;
    private File file;


    public ConfigurationHandler(TSDataCollectionBot bot) {
        this.bot = bot;
        objectMapper = new ObjectMapper(new YAMLFactory());
    }
    /**
     * Loads the configuration from the file
     * @throws IOException if an error occurs
     */
    public void loadConfiguration() throws IOException {
        File file = new File("config.yaml");
        if(!file.exists()){
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.yaml");
            Files.copy(inputStream, Paths.get("config.yaml"));
        }

        configuration = objectMapper.readValue(file, Configuration.class);
    }


    public Configuration getConfiguration() {
        return configuration;
    }
}

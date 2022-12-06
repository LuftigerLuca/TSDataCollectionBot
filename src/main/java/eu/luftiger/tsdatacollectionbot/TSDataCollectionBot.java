package eu.luftiger.tsdatacollectionbot;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import eu.luftiger.tsdatacollectionbot.configuration.ConfigurationHandler;
import eu.luftiger.tsdatacollectionbot.database.DataSourceProvider;
import eu.luftiger.tsdatacollectionbot.database.DatabaseSetup;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * The main class of the bot
 */
public class TSDataCollectionBot {

    private ConfigurationHandler configurationHandler;

    private DataSource dataSource;

    private Logger logger;
    private TS3Config config;
    private TS3Query query;
    private TS3Api api;

    /**
     * Initializes the bot
     */
    public static void main(String[] args) {
        new TSDataCollectionBot().run();
    }

    /**
     * Initializes the bot
     */
    public void run() {
        logger = Logger.getLogger("TSDataCollectionBot");

        logger.info("TSDataCollectionBot started...");
        logger.info("Loading configuration...");
        configurationHandler = new ConfigurationHandler(this);
        try {
            configurationHandler.loadConfiguration();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("Configuration loaded!");

        logger.info("Connecting to database...");
        /*
        try {
            dataSource = DataSourceProvider.initMySQLDataSource(this, configurationHandler.getConfiguration());
            DatabaseSetup.initDatabase(this, dataSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         */

        logger.info("Connecting to TeamSpeak...");
        config = new TS3Config();
        config.setHost(configurationHandler.getConfiguration().getTeamSpeakHost());

        query = new TS3Query(config);
        query.connect();

        api = query.getApi();
        api.login(configurationHandler.getConfiguration().getTeamSpeakQueryUsername(), configurationHandler.getConfiguration().getTeamSpeakQueryPassword());
        api.selectVirtualServerById(configurationHandler.getConfiguration().getTeamSpeakServerId());
        api.setNickname(configurationHandler.getConfiguration().getBotName());

        logger.info("TeamSpeak connected!");



    }

    public Logger getLogger() {
        return logger;
    }
}

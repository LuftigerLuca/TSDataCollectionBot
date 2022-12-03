package eu.luftiger.tsdatacollectionbot;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;

import java.util.logging.Logger;

public class TSDataCollectionBot {

    private Logger logger;
    private TS3Config config;
    private TS3Query query;
    private TS3Api api;

    public static void main(String[] args) {
        new TSDataCollectionBot().run();
    }

    public void run(){
        logger.info("TSDataCollectionBot started...");

    }
}

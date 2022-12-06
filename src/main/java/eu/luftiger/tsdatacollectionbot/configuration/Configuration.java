package eu.luftiger.tsdatacollectionbot.configuration;

/**
 * Represents the configuration of the bot
 */
public record Configuration(BotConfiguration bot,
                            TeamSpeakConfiguration teamSpeak,
                            DatabaseConfiguration database) {

    public String getBotName(){
        return bot.name();
    }

    public String getTeamSpeakHost(){
        return teamSpeak.host();
    }

    public int getTeamSpeakServerId(){
        return teamSpeak.serverId();
    }

    public int getTeamSpeakQueryPort(){
        return teamSpeak.queryPort();
    }

    public String getTeamSpeakQueryUsername(){
        return teamSpeak.queryUsername();
    }

    public String getTeamSpeakQueryPassword(){
        return teamSpeak.queryPassword();
    }

    public String getDatabaseHost(){
        return database.host();
    }

    public int getDatabasePort(){
        return database.port();
    }

    public String getDatabaseName(){
        return database.databaseName();
    }

    public String getDatabaseUsername(){
        return database.user();
    }

    public String getDatabasePassword(){
        return database.password();
    }





}

/**
 * Represents the configuration of the bot
 */
record BotConfiguration(String name){
}

/**
 * Represents the configuration of the TeamSpeak-server
 */
record TeamSpeakConfiguration(String host,
                              int serverId,
                              int queryPort,
                              String queryUsername,
                              String queryPassword) {
}

/**
 * Represents the configuration of the database
 */
record DatabaseConfiguration(String host,
                             int port,
                             String databaseName,
                             String user,
                             String password) {
}

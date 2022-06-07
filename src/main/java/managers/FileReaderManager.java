package managers;

import dataProviders.ConfigFileReader;
import dataProviders.JsonFileReader;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static JsonFileReader jsonFileReader;

    private FileReaderManager() {}

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
    }

    public JsonFileReader getJsonReader() {
        return (jsonFileReader == null) ? jsonFileReader = new JsonFileReader() : jsonFileReader;
    }
}
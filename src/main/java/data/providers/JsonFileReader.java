package data.providers;

import com.google.gson.Gson;
import data.types.TestCaseData;
import managers.FileReaderManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class JsonFileReader {
    private final String testDataFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "TestData.json";
    private final List<TestCaseData> testCaseList;

    public JsonFileReader(){
        testCaseList = getTestData();
    }

    private List<TestCaseData> getTestData() {
        // Gson is a Java library that can be used to convert Java Objects into their JSON representation.
        Gson gson = new Gson();
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(testDataFilePath))) {
            TestCaseData[] pages = gson.fromJson(bufferReader, TestCaseData[].class);
            return Arrays.asList(pages);
        } catch (IOException e) {
            throw new RuntimeException("Json file not found at path : " + testDataFilePath);
        }
    }

    public final TestCaseData getTestDataByTestCaseID(String testCaseId){
        return testCaseList.stream().filter(x -> x.testCaseId.equalsIgnoreCase(testCaseId)).findAny().get();
    }
}
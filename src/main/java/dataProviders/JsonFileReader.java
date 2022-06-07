package dataProviders;

import com.google.gson.Gson;
import dataTypes.TestCaseData;
import managers.FileReaderManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonFileReader {
    private final String testDataFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "TestData.json";
    private List<TestCaseData> testCaseList;

    public JsonFileReader(){
        testCaseList = getTestData();
    }

    private List<TestCaseData> getTestData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(testDataFilePath));
            TestCaseData[] pages = gson.fromJson(bufferReader, TestCaseData[].class);
            return Arrays.asList(pages);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + testDataFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final TestCaseData getTestDataByTestCaseID(String testCaseId){
        return testCaseList.stream().filter(x -> x.testCaseId.equalsIgnoreCase(testCaseId)).findAny().get();
    }
}
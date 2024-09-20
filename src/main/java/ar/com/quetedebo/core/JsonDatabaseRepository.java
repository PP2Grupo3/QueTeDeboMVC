package ar.com.quetedebo.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class JsonDatabaseRepository implements DatabaseRepository {

    private final String walletsFilePath;
    private final String debtsFilePath;

    public JsonDatabaseRepository(String walletsFilePath, String debtsFilePath) {
        this.walletsFilePath = walletsFilePath;
        this.debtsFilePath = debtsFilePath;
    }

    @Override
    public List<Wallet> findAllWallets() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(walletsFilePath), new TypeReference<List<Wallet>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Debt> findAllDebts() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(debtsFilePath), new TypeReference<List<Debt>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

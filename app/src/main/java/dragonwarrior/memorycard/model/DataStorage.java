package dragonwarrior.memorycard.model;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by casdong on 12/11/16.
 */
public class DataStorage {
    private static String FILE_NAME = "memoryCardData.txt";
    private static String FILE_PATH = "dataStorage";
    private static String SEPARATOR = "&&&";
    private final Context m_context;
    private final File m_file;

    public DataStorage(Context context) {
        m_context = context;
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            File directory = context.getDir(FILE_PATH, Context.MODE_APPEND);
            m_file = new File(directory , FILE_NAME);

        } else {
            m_file = new File(m_context.getExternalFilesDir(FILE_PATH), FILE_NAME);
        }

        if (getAllData().size() == 0) {
            initialData();
        }
    }

    public void saveAllData(List<DataPair> dataPairs) {
        try {
            FileOutputStream stream = new FileOutputStream(m_file, false);
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            for (DataPair dataPair : dataPairs) {
                writer.append(dataPair.m_a.toString() + SEPARATOR + dataPair.m_b.toString() + "\n");
            }
            writer.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addData(DataPair dataPair) {
        try {
            FileOutputStream stream = new FileOutputStream(m_file, true);
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            writer.append(dataPair.m_a.toString() + SEPARATOR + dataPair.m_b.toString() + "\n");
            writer.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    public List<DataPair> getGameDatas() {
        List<DataPair> allData = getAllData();
        if (allData == null) return null;
        if (allData.size() <= 6) {
            return allData;
        }
        Collections.shuffle(allData);
        return allData.subList(0, 6);
    }

    public List<DataPair> getAllData() {
        List<DataPair> dataPairs = new ArrayList<>();
        try {
            FileInputStream stream = new FileInputStream(m_file);
            DataInputStream in = new DataInputStream(stream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = reader.readLine()) != null ) {
                DataPair dataPair = getDataPairs(strLine);
                if (dataPair != null) dataPairs.add(dataPair);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
           return dataPairs;
    }

    private DataPair getDataPairs(String strLine) {
        if (strLine.indexOf(SEPARATOR) == -1) return null;
        String cardA = strLine.substring(0, strLine.indexOf(SEPARATOR));
        String cardB = strLine.substring(strLine.lastIndexOf(SEPARATOR) + SEPARATOR.length(), strLine.length());
        return new DataPair(cardA, cardB);
    }

    private void initialData() {
        List<DataPair> dataPairs = new ArrayList<>();

        dataPairs.add(new DataPair("Hello", "你好"));
        dataPairs.add(new DataPair("any", "任何"));
        dataPairs.add(new DataPair("Language", "语言"));
        dataPairs.add(new DataPair("you", "你"));
        dataPairs.add(new DataPair("want", "想"));
        dataPairs.add(new DataPair("learn", "学习"));

        saveAllData(dataPairs);
    }
}

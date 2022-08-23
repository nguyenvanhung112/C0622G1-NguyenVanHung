package bai_tap_lam_them.ulti;

import bai_tap_lam_them.model.Teacher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileUlti {
    //    public static void writeFile(String src, boolean append, List<String> list) {
//        FileWriter fileWriter;
//        try {
//            fileWriter = new FileWriter(src, append);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (String s : list) {
//                bufferedWriter.write(s);
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
}


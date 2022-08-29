package case_study.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUlti {
    public static List<String> readFile(String path) throws IOException {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            if (!file.exists()) {
                throw new FileNotFoundException("File không tồn tại or nội dung có lỗi");
            }
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
        return strings;
    }
}

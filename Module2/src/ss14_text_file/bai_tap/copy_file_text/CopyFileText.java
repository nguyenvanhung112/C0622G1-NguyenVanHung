package ss14_text_file.bai_tap.copy_file_text;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    private List<String> readFile() {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File("src\\ss14_text_file\\bai_tap\\copy_file_text\\source file.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                strings.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
        return strings;
    }

    public void writeFile(List<String> copy, int count) {
        try {
            FileWriter fileWriter = new FileWriter("src\\ss14_text_file\\bai_tap\\copy_file_text\\target file.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(copy + " Tổng số kí tự là " + count);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countCharacter(List<String> copy) {
        int count = 0;
        for (int i = 0; i < copy.size(); i++) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        List<String> copy = copyFileText.readFile();
        int count = countCharacter(copy);
        copyFileText.writeFile(copy, count);
    }
}

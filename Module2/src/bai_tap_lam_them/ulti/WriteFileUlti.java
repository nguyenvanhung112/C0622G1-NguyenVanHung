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
//    public static <E> String writeFileLine(String path, List<E> persons) throws IOException{
//        String data="";
//        for(E person:persons){
//            data+=person.toString();
//            data+="\n";
//        }
//        return data;
//    }
//public static void writeStudentFile(String path, List<Student> students) throws IOException {
//    String data = "";
//    for (Student student : students) {
//        data += student.toString();
//        data += "\n";
//    }
//    data+= WriteFileUtil.writeFileLine(PATH_NAME_FILE_STUDENT,TeacherService.readTeacherFile(PATH_NAME_FILE_STUDENT));
//    WriteFileUtil.writeFile(path, data);
//}
}


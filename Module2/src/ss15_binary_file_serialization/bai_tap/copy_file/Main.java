package ss15_binary_file_serialization.bai_tap.copy_file;

import ulti_exception.FileSoureIsEmpty;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main {
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void countByte() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src\\ss15_binary_file_serialization\\thuc_hannh\\copyfile\\controller\\dest");
        long size = fileInputStream.getChannel().size();
        System.out.println("Size = " + size + "byte");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String sourcePath = "src\\ss15_binary_file_serialization\\thuc_hannh\\copyfile\\controller\\source";
        String destPath = "src\\ss15_binary_file_serialization\\thuc_hannh\\copyfile\\controller\\dest";
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        if (destFile.exists()) {
            System.out.println("File đích đã tồn tại");
        }
        try {
            copyFileUsingJava7Files(sourceFile, destFile);
            copyFileUsingStream(sourceFile, destFile);
            if (sourceFile.length() == 0) {
                throw new FileSoureIsEmpty("File cần sao chép đang trống");
            } else {
                System.out.println("Sao chép thành công");
                countByte();
            }
        } catch (FileSoureIsEmpty e) {
            System.out.println(e.getMessage());
        } catch (IOException ioe) {
            System.out.println("Không thể sao chép");

        }
    }
}

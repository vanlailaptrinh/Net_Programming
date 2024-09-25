package Bai1_TH1.Delete;

import java.io.File;

public class Delete {
    public boolean delete(String path) {
        File file = new File(path);
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                    return true;
                }
                if (file.isDirectory()) {

                        File[] files = file.listFiles();
                        for (File f : files) {
                            delete(f.getAbsolutePath());
                        }
                        file.delete();
                        //Mo rong chi xoa file ma giu cau truc thu muc thi cmt đoan tren
                    return true;

                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
        public static void main (String[]args){
            Delete folder = new Delete();
            System.out.println(folder.delete("D:\\ExerciseNetProgram_Java\\Test"));
        }
    }

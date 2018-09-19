package File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 批量修改文件名
 * User: hanchenghai
 * Date: 2018/09/19 上午11:01
 */
public class FileNote2 {
    private static final String fileDir = "/Users/hanchenghai/Desktop/Practice/JavaPractice/Basic/src/File/";

    public static void main(String[] args) {
        File dir = new File(fileDir);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.getName().contains("xxxxx")) {
                String newName = file.getName().replace("xxxxxx", "");
                file.renameTo(new File(dir, newName));
            }
        }
    }
}

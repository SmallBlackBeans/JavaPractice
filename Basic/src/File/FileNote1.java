package File;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 遍历父级路径
 * User: hanchenghai
 * Date: 2018/09/19 上午10:49
 */
public class FileNote1 {

    /**
     * /Users/hanchenghai/Desktop/Practice/JavaPractice/Basic/src/File/FileNote1.java
     */

    private static final String filePath = "/Users/hanchenghai/Desktop/Practice/JavaPractice/Basic/src/File/FileNote1.java";
    private static List<String> parents = new ArrayList<>();

    public static void main(String[] args) {
        File file = new File(filePath);
        fileParentName(parents,file);
        Collections.reverse(parents);
        StringBuilder sb = new StringBuilder();
        for (String name : parents) {
            sb.append(name + ">");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static void fileParentName(List<String> parents, File file) {
        if (!"".equals(file.getParentFile().getName())) {
            parents.add(file.getParentFile().getName());
        }
        if (file.getParentFile().getParentFile() != null) {
            fileParentName(parents,file.getParentFile());
        }
    }

}

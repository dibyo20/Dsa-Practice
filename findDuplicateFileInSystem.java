import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findDuplicateFileInSystem {
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String parts[] = path.split(" ");
            String dir = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String file = parts[i];
                int idx = file.indexOf("(");

                String filename = file.substring(0, idx);
                String content = file.substring(idx + 1, file.length() - 1);

                String fullPath = dir + "/" + filename;

                map.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath);
            }
        }
        List<List<String>> result = new ArrayList<>();

        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.add(list);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String paths[] = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }
}

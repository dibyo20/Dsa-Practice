import java.util.Stack;

public class stackSimplifyDirectoryPath {
    public static String simplifyPath(String path) {
        Stack<String> s = new Stack<>();

        String parts[] = path.split("/");

        for(String part : parts){
            if(part.equals("") || part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }else{
                s.push(part);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder();
        for(String dir : s){
            simplifiedPath.append("").append(dir);
        }

        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
    }

    public static void main(String[] args) {
        String path = "\\Users\\dibyo\\OneDrive\\Desktop\\JAVA";
        System.out.println(simplifyPath(path));
    }
}

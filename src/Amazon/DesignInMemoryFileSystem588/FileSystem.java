package Amazon.DesignInMemoryFileSystem588;

import java.util.*;

/**
 * Design a data structure that simulates an in-memory file system.
 *
 * Implement the FileSystem class:
 *
 * FileSystem() Initializes the object of the system.
 * List<String> ls(String path)
 * If path is a file path, returns a list that only contains this file's name.
 * If path is a directory path, returns the list of file and directory names in this directory.
 * The answer should in lexicographic order.
 * void mkdir(String path) Makes a new directory according to the given path. The given directory path does not exist. If the middle directories in the path do not exist, you should create them as well.
 * void addContentToFile(String filePath, String content)
 * If filePath does not exist, creates that file containing given content.
 * If filePath already exists, appends the given content to original content.
 * String readContentFromFile(String filePath) Returns the content in the file at filePath.
 */
public class FileSystem {
    HashMap<String, File> map;
    File root;
    public FileSystem() {
        map = new HashMap<>();
        root = new File(0,"/");
        map.put("/",root);
    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        if(!map.containsKey(path)){
            return result;
        }
        if(map.get(path).type==1){
            result.add(map.get(path).name);
            return result;
        }

        result = new ArrayList<>(map.get(path).set);
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        String[] pathArr = path.split("/");
        File cur = root;
        StringBuilder sb = new StringBuilder("/");
        for(int i = 1;i<pathArr.length;i++){
            // 当前有文件夹->进入
            sb.append(pathArr[i]);
            if(cur.set.contains(pathArr[i])){
                cur = map.get(sb.toString());
            } else {
                map.put(sb.toString(), new File(0,pathArr[i]));
                cur.set.add(pathArr[i]);
                cur = map.get(sb.toString());
            }
            sb.append("/");
            // 没有当前文件夹-》 创建 -》 加入hashMap
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] pathArr = filePath.split("/");
        File cur = root;
        StringBuilder sb = new StringBuilder("/");
        for(int i = 1;i<pathArr.length-1;i++){
            // 当前有文件夹->进入
            sb.append(pathArr[i]);
            if(cur.set.contains(pathArr[i])){
                cur = map.get(sb.toString());
            } else {
                map.put(sb.toString(), new File(0,pathArr[i]));
                cur.set.add(pathArr[i]);
                cur = map.get(sb.toString());
            }
            sb.append("/");
            // 没有当前文件夹-》 创建 -》 加入hashMap
        }
        sb.append(pathArr[pathArr.length-1]);
        if(cur.set.contains(pathArr[pathArr.length-1])){
            map.get(sb.toString()).content += content;
        } else {
            map.put(sb.toString(),new File(1,pathArr[pathArr.length-1],content));
            cur.set.add(pathArr[pathArr.length-1]);
        }
    }

    public String readContentFromFile(String filePath) {
        return map.get(filePath).content;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.ls("/");
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d","hello");
        fs.ls("/");
        fs.readContentFromFile("/a/b/c/d");
    }
}

class File{
    int type; //0: directory; 1: file
    String name; // 当前文件夹或者文件的名称
    String content; // file 下的内容

    HashSet<String> set; // directory下的子文件

    //  file
    public File(int type, String name, String content){
        this.type = type;
        this.name = name;
        this.content = content;
    }

    // directory
    public File(int type, String name){
        this.type = type;
        this.name = name;
        set = new HashSet<>();
    }

}
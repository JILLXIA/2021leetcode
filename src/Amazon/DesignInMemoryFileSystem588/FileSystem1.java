package Amazon.DesignInMemoryFileSystem588;

import java.util.*;

public class FileSystem1 {
    File1 root;
    public FileSystem1() {
        root = new File1(0,"/");
    }

    public List<String> ls(String path) {
        String[] sPath = path.split("/");
        File1 cur = root;

        for(int i = 1;i< sPath.length;i++){
            if(!cur.map.containsKey(sPath[i])){
                break;
            }
            cur = cur.map.get(sPath[i]);
        }
        if(cur.type==1){
            List<String> result = new ArrayList<>();
            result.add(cur.name);
            return result;
        }
        List<String> result = new ArrayList<>(cur.map.keySet());
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        String[] sPath = path.split("/");
        File1 cur = root;
        for(int i = 1;i<sPath.length;i++){
            if(!cur.map.containsKey(sPath[i])){
                cur.map.put(sPath[i],new File1(0,sPath[i]));
            }
            cur = cur.map.get(sPath[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] sPath = filePath.split("/");
        File1 cur = root;
        for(int i = 1;i<sPath.length-1;i++){
            if(!cur.map.containsKey(sPath[i])){
                cur.map.put(sPath[i],new File1(0,sPath[i]));
            }
            cur = cur.map.get(sPath[i]);
        }
        if(cur.map.containsKey(sPath[sPath.length-1])){
            cur.map.get(sPath[sPath.length-1]).content += content;
        } else {
            cur.map.put(sPath[sPath.length-1],new File1(1,sPath[sPath.length-1],content));
        }
    }

    public String readContentFromFile(String filePath) {
        String[] sPath = filePath.split("/");
        File1 cur = root;
        for(int i = 1;i<sPath.length;i++){
            if(!cur.map.containsKey(sPath[i])){
                return null;
            }
            cur = cur.map.get(sPath[i]);
        }
        return cur.content;
    }
}

class File1{
    int type; //0: directory; 1: file
    String name; // 当前文件夹或者文件的名称
    String content; // file 下的内容

    HashMap<String, File1> map; // directory下的子文件

    //  file
    public File1(int type, String name, String content){
        this.type = type;
        this.name = name;
        this.content = content;
    }

    // directory
    public File1(int type, String name){
        this.type = type;
        this.name = name;
        map = new HashMap<>();
    }

}
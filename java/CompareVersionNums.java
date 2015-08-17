public class Solution {
    public int compareVersion(String version1, String version2) {
    	List<String> v1 = new ArrayList<String>();
    	List<String> v2 = new ArrayList<String>();
        if(!version1.contains(".")){
            v1.add(version1);
        }else{
            String[] tmp = version1.split("\\.");
            for(int i = 0; i < tmp.length; i ++){
            	v1.add(tmp[i]);
            }
        }
        if(!version2.contains(".")){
            v2.add(version2);
        }else{
            String[] tmp = version2.split("\\.");
            for(int i = 0; i < tmp.length; i ++){
            	v2.add(tmp[i]);
            }
        }
        for(int i = 0; i < Math.min(v1.size(), v2.size()); i++){
            if(Integer.parseInt(v1.get(i)) < Integer.parseInt(v2.get(i))) {
                return -1;
            }else if(Integer.parseInt(v1.get(i)) > Integer.parseInt(v2.get(i))){
                return 1;
            }else{
                continue;
            }
        }
        if(v1.size() < v2.size()){
            for(int i = v1.size(); i < v2.size(); i++){
                if(Integer.parseInt(v2.get(i)) != 0){
                    return -1;
                }
            }
        }else if(v1.size() > v2.size()){
            for(int i = v2.size(); i < v1.size(); i++){
                if(Integer.parseInt(v1.get(i)) != 0){
                    return 1;
                }
            }
        }
        return 0;
        
    }
}
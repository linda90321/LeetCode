import java.util.HashMap;


public class wordPattern290 {
	public boolean wordPattern(String pattern, String str) {
        if((pattern.length() == 0 && str.length() != 0) || (pattern.length() != 0 && str.length() == 0))
        return false;
        
        String[] tempPattern = pattern.split("");
        String[] tempStr = str.split(" ");

        if(tempPattern.length != tempStr.length)
        return false;
        
        HashMap<String,String> map = new HashMap<String,String>();
        for(int i=0;i<tempPattern.length;i++){
            if(map.containsKey(tempPattern[i])){
                if(map.get(tempPattern[i]).equals(tempStr[i]))
                continue;
                else
                return false;
            }else{
                /*
                "abba"
                "dog dog dog dog"
                */
                if(!map.containsValue(tempStr[i]))
                map.put(tempPattern[i],tempStr[i]);
                else
                return false;
            }
        }
        
        
        return true;
    }
}

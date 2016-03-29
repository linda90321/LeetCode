public class reverseWordsInString151 {
    public String reverseWords(String s) {
        if(s.length() == 0 || s == null)
        return "";
        StringBuilder sb=new StringBuilder();
        String[] temp=s.split(" ");
        for(int i=temp.length-1;i>=0;i--){
            if(!temp[i].equals("")){
                sb.append(temp[i]).append(" ");
            }
        }
        
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}

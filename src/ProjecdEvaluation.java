public class ProjecdEvaluation {

    public static void main(String[] args) {

        String str = "mam";
         System.out.println(checkPalindrome(str));
    }

     public static Boolean checkPalindrome(String str) {
        StringBuffer sb = new StringBuffer();

        for(int i =str.length() -1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        System.out.println("get revers of input str:"+sb.toString());
        if( str.equals(sb.toString()) ){
            return true;
        }else{
            return false;
        }
    }


}

public class Contact {
    String firstName,lastName,phone,address;
    Contact(String firstName,String lastName,String phone,String address){
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.phone      = phone;
        this.address    = address;
    }
    public static String convertToNumer(String str){
        String newStr   = "";
        for(int i=0;i<str.length();i++){
            char c  = str.charAt(i);
            if(c>=97 && c<=99){
                newStr+='2';
            }
            if(c>=100 && c<=102){
                newStr+='3';
            }
            if(c>=103 && c<=105){
                newStr+='4';
            }
        }
        return newStr;
    }
}

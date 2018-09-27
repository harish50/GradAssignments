
public class DailerApp {

    public Contact contacts[] ;

    DailerApp(){}

    DailerApp(Contact []contacts){
        this.contacts   = contacts;
    }

    public String searchWithDialPad(String dialPadString){
        String output= "NotFound";
        Boolean last = false,phnNumber1 = false,phnNumber2 = false;

        for(Contact contact:this.contacts){
            if (dialPadString.equals(convertToNumber(contact.firstName))){
                return contact.firstName+contact.lastName;
            }
            else if (!last && dialPadString.equals(convertToNumber(contact.lastName))){
                    last    = true;
                    output  = contact.firstName+contact.lastName;

            }
            else if (!last && !phnNumber1 && dialPadString.equals(contact.phone.split(" ")[0])){
                    phnNumber1  = true ;
                    output  = contact.firstName + contact.lastName;

            }
            else if (!last && !phnNumber1 && !phnNumber2 && dialPadString.equals(contact.phone.split(" ")[1])){
                    phnNumber2  = true;
                    output  = contact.firstName + contact.lastName;
            }
        }
        return output;
    }
    public  String convertToNumber(String str){
        String newStr   = "";
        str             = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            char c  = str.charAt(i);

            if(c>=97 && c<=99){
                newStr  = newStr.concat("2");
            }
            else if(c>=100 && c<=102){
                newStr  = newStr.concat("3");
            }
            else if(c>=103 && c<=105){
                newStr  = newStr.concat("4");
            }
            else if(c>=106 && c<=108){
                newStr  = newStr.concat("5");
            }
            else if(c>=109 && c<=111){
                newStr  = newStr.concat("6");
            }
            else if(c>=112 && c<=115){
                newStr  = newStr.concat("7");
            }
            else if (c>=116 && c<=118){
                newStr  = newStr.concat("8");
            }
            else if (c>=119 && c<=122) {
                newStr  = newStr.concat("9");
            }
        }
        return newStr;
    }
}

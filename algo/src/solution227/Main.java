package solution227;

public class Main {
    public static void main(String[] args) {

        String tmp = "fdsafsd";
        System.out.println("5123123");

        System.out.println(tmp.substring(tmp.length()));
        solution("abcdefghijklmn.p");

    }

    public static String solution(String new_id) {


        new_id = new_id.toLowerCase();
        System.out.println(new_id);

        char two[] = new_id.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char word : two){
            if((word >='a' && word <='z') || (word >='0' && word <='9') || word == '-' || word == '_'||word=='.' ){
                sb.append(word);
            }
        }

        String three = sb.toString();
        //3단계

        while(three.contains("..")){
            three = three.replace("..",".");
        }

        //4단계
        if(three.startsWith(".")){
            three = three.substring(1);
        }
        if(three.endsWith(".")){
            three =  three.substring(0,three.length()-1);
        }


        //5단계
        if(three.isEmpty()){
            three = "a";
        }

        //6단계
        String six= three ;
        if(six.length() >=16){
            six = six.substring(0,15);
        }
        System.out.println("six"+six);
        if(six.endsWith(".")){
            six = six.substring(0,six.length()-1);
        }

        while(six.length()<=2){
            six += six.substring(six.length()-1);
        }


        


        return six;
    }
}


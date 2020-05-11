package Assignment7;

public class Logic {
    public Model add(String first, String second){
        int sum=0;
        if(first.equals("")){
            first="0";
        }
        if (second.equals("")){
            second="0";
        }
        try{
            sum= Integer.parseInt(first)+ Integer.parseInt(second);
        }catch (Exception e){
            System.out.println("please enter valid input!");
        }

       return new Model(sum);

    }
}

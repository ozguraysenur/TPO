package tpo5;

import java.util.ArrayList;
import java.util.List;

public class Model {

    List<Integer> results= new ArrayList<>();

    public final int sum ;

    public Model(int _sum){
        sum=_sum;
        results.add(sum);
    }

    public List<Integer> getList(){
        return results;
    }

    public int getSum(){
        return sum;
    }

}

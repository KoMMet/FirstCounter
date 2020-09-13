package data;

import java.util.Random;

public class Problem {
    private String problemString;
    public String getProblemString() { return problemString; }
    private int answer;
    public int getAnswer() { return answer; }

    private Random random;
    public Problem(GameArithmetic gameArithmetic )
    {
        random = new Random();
        create(gameArithmetic);
    }

    private void create(GameArithmetic gameArithmetic ) {
        int ans = random.nextInt(9)+1;
        answer = ans;
        int arith;
        if(gameArithmetic == GameArithmetic.PlusMinusDiv){arith = random.nextInt(3);}
        else if(gameArithmetic == GameArithmetic.PlusMinus){arith = random.nextInt(2);}
        else if(gameArithmetic == GameArithmetic.OnlyPlus){arith = 0;}
        else if(gameArithmetic == GameArithmetic.PlusMinus){arith = 1;}
        else if(gameArithmetic == GameArithmetic.OnlyDiv){arith = 2;}
        else {arith = 0;}

        if(arith == 0){plus(ans);}
        else if(arith == 1){minus(ans);}
        else if(arith == 2){answer=div();}
    }

    private int div(){
        int ans = random.nextInt(9)+1;
        int tmp = random.nextInt(9)+1;
        int tmp2=ans*tmp;
        problemString = String.valueOf(tmp2).concat(" ÷ ").concat(String.valueOf(tmp)).concat("=");
        return ans;
    }

    private void minus(int ans) {
        int rv = random.nextInt(ans);
        int lv = ans + rv;
        problemString = String.valueOf(lv).concat(" - ").concat(String.valueOf(rv)).concat("=");
    }

    private void plus(int ans) {
        int i = (random.nextInt(ans));
        int ii = ans - i;
        problemString = String.valueOf(i).concat(" + ").concat(String.valueOf(ii)).concat("=");
    }

}

package Stack;

public class EvaluateReversePolishNotation {
    

    public int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<String>s = new Stack<>();

        for(String tk: tokens){
           if(!operators.contains(tk)){
            s.push(tk);
           } else{
            int a = Integer.parseInt(s.pop());
            int b = Integer.parseInt(s.pop());

            int index = operators.indexOf(tk);

             switch(index){
                case 0:
                 s.push(String.valueOf(a+b));
                  break;

                case 1:
                 s.push(String.valueOf(b - a));
                  break;

                case 2:
                s.push(String.valueOf(a * b));
                 break;

                case 3:
                 s.push(String.valueOf(b / a));
                    break;
             }
           }
        }
        return Integer.parseInt(s.pop());
    }
}
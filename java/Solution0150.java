class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        String a , b ,res;
        for(String token: tokens ) {
            if(isOperator(token)) {
                b = stack.pop();
                a = stack.pop();
                res = op(token, a, b);
                stack.push(res);
            } else {
                stack.push(token);
            }
        }
        res = stack.pop();
        return Integer.parseInt(res); 
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/");
    }

    private String op(String operator, String a, String b) {
        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        int res = 0;
        switch(operator) {
            case "+":
                res = numA + numB;
                break;
            case "-":
                res = numA - numB;
                break;
            case "*":
                res=  numA * numB;
                break;
            case "/":
                res =  numA / numB;
        }
        return res + "";
    }
}

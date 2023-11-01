class Solution {
    public boolean isValid(String s) {
        if (s.length() %2 ==1) return false;
        Stack<Character> stack = new Stack();
        for ( Character ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop()!= '(') return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!= '{') return false;
                        break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!= '[') return false;
                        break;
            }
        }
        return stack.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(Character c: s.toCharArray()){
            if(c == '(' || c=='[' || c=='{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                Character pre = stack.pop();
                if((c == ')' && pre == '(')
                || (c == ']' && pre == '[')
                || (c == '}' && pre == '{')
                ) continue;
                else return false;
            }
        }
        return stack.isEmpty();
    }


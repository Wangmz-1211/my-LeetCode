class Solution {
        public List<String> fizzBuzz(int n) {
        List<String> answer= new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            if (i%3==0) temp +=3;
            if (i%5==0) temp +=5;
            switch (temp) {
                case 0:
                    answer.add(String.valueOf(i));
                    break;
                case 3:
                    answer.add("Fizz");
                    break;
                case 5:
                    answer.add("Buzz");
                    break;
                case 8:
                    answer.add("FizzBuzz");
                    break;
            }
        }
        return answer;
    }
}

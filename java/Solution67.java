class Solution {
    public String addBinary(String a, String b) {
        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();
        StringBuffer sb = new StringBuffer();
        int ap = arr.length-1;
        int bp = brr.length-1;
        char tmp = '0';
        while (ap >=0 && bp >=0 ) {
            int flag = arr[ap] + brr[bp] + tmp;
            ap --;
            bp --;
            if (flag == '0'*3) {
                sb.append('0');
                continue;
            } 
            if (flag == '0'*2 + '1') {
                tmp = '0';
                sb.append('1');
                continue;
            }
            if (flag == '0' + '1'*2) {
                tmp  = '1';
                sb.append('0');
                continue;
            }
            if (flag == '1'*3) {
                tmp = '1';
                sb.append('1');
                continue;
            }
        }
        while ( ap >=0) {
            int flag = arr[ap] + tmp;
            ap --;
            if (flag == '0'*2) {
                sb.append('0');
                continue;
            }
            if (flag == '0' + '1') {
                tmp  = '0';
                sb.append('1');
                continue;
            }
            if (flag == '1'*2) {
                tmp = '1';
                sb.append('0');
                continue;
            }
        }
        while ( bp >=0) {
            int flag = brr[bp] + tmp;
            bp --;
            if (flag == '0'*2) {
                sb.append('0');
                continue;
            }
            if (flag == '0' + '1') {
                tmp  = '0';
                sb.append('1');
                continue;
            }
            if (flag == '1'*2) {
                tmp = '1';
                sb.append('0');
                continue;
            }
        }
        if(tmp == '1') sb.append('1');
        return sb.reverse().toString();
    }
}

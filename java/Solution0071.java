class Solution {
    public String simplifyPath(String path) {
        String[] subpaths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String subpath: subpaths) {
            switch (subpath) {
                case ".":
                    break;
                case "..":
                    if(!stack.isEmpty()) stack.pop();
                    break;
                default:
                    if(!subpath.equals("")) stack.push(subpath);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append('/');
            sb.append(stack.pollLast());
        }
        if(sb.length() == 0) return "/";
        return sb.toString();
    }
}

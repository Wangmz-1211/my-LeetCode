/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        handleSerialize(root, sb);
        return sb.toString();
    }
    public void handleSerialize(TreeNode root, StringBuffer sb){
        if(root == null){
            sb.append("#_");
            return;
        } else {
            sb.append(root.val+"_");
            handleSerialize(root.left, sb);
            handleSerialize(root.right, sb);
        }
    }
    int i = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split("_");
        if( strings[0].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strings[i++]));
        handleDeserialize(root, strings);
        return root;
    }
    public void handleDeserialize(TreeNode root, String[] data){
        if (data[i].equals("#")) {
            root.left = null;
            i++;
        } else {
            root.left = new TreeNode(Integer.parseInt(data[i++]));
            handleDeserialize(root.left, data);
        }
        if (data[i].equals("#")) {
            root.right = null;
            i++;
        } else {
            root.right = new TreeNode(Integer.parseInt(data[i++]));
            handleDeserialize(root.right, data);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

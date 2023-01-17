package oy.tol.tra;

public class TreeNode<K extends Comparable<K>, V>{
    
    // private members
    private int hash;
    private Pair<K,V> keyValue;
    private TreeNode<K,V> leftChild;
    private TreeNode<K,V> rightChild;

    // stats
    public static int depth = 0;
    public static int collisionChainLength = 0;

    public TreeNode(K key, V value){
        keyValue = new Pair<K,V>(key, value);
        hash = key.hashCode();
        leftChild = null;
        rightChild = null;
    }
    /**
     * Inserts key, value pair to child of TreeNode using hashcode to choose child
     * if chosen child has a key, value pair {@code insert()} key value pair to chosen child children.
     * if hash is same as TreeNode compares them if they are same updates value otherwise 
     * @param key
     * @param value
     * @return
     */
    public boolean insert(K key, V value, int keyToSearch){
        boolean added = false;
        if (keyToSearch < this.hash){
            if (leftChild == null){
                leftChild = new TreeNode<K,V>(key, value);
                depth++;
                added = true;
            } else {
                depth++;
                added = leftChild.insert(key, value, keyToSearch);
            }
        } else if (keyToSearch > this.hash){
            if (rightChild == null){
                rightChild = new TreeNode<K,V>(key, value);
                depth++;
                added = true;
            } else {
                depth++;
                added = rightChild.insert(key, value, keyToSearch);
            }
        } else {
            if (keyValue.getKey().equals(key)){
                keyValue.setvalue(value);
            } else if (leftChild == null){   // added same hash code different keys to left child
                collisionChainLength = 1; 
                leftChild = new TreeNode<K,V>(key, value); //!!! might slow down performance because finding and adding gets more complicated
                added = true;
            } else {
                collisionChainLength++;
                added = leftChild.insert(key, value, keyToSearch);
            } 
        }
        return added;
    }

    public V find(K key, int toFindHash) throws IllegalArgumentException {
        V result = null;
        if (toFindHash < this.hash){
            if (leftChild != null){
                result = leftChild.find(key, toFindHash);
            }
        } else if (toFindHash > this.hash){
            if (rightChild != null){
                result = rightChild.find(key, toFindHash);
            }
        } else {
            if (keyValue.getKey().equals(key)){
                return keyValue.getValue();
            }
            if (leftChild != null){ // if same hash code looking from leftchild onwards
                result = leftChild.find(key, toFindHash);
            } 
        }
        return result;
    }

    public void toSortedArray(Pair<K,V> [] array, int [] toAddIndex){
        if (leftChild != null){
            leftChild.toSortedArray(array, toAddIndex);
        }
        array[toAddIndex[0]] = new Pair<K,V>(keyValue.getKey(),keyValue.getValue());
        toAddIndex[0] = toAddIndex[0] + 1;

        if (rightChild != null){
            rightChild.toSortedArray(array, toAddIndex);
        }
    }
}

package bstmap;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private Node root;

    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public BSTMap() {
        this.size = 0;
    }

    public void clear() {
        root = clear(root);
        this.size = 0;
    }

    private Node clear(Node node) {
        if (node == null) {
            return null;
        }
        node.left = clear(node.left);
        node.right = clear(node.right);
        return null;
    }

    // help method, search the node whose key equals key, from node
    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public boolean containsKey(K key) {
        return get(root, key) != null;
    }

    public V get(K key) {
        Node node = get(root, key);
        if (node == null) {
            return null;
        }
        return node.val;
    }

    public int size() {
        return this.size;
    }

    // help method, search the node with key, if not, create one.
    private Node put(Node node, K key, V val) {
        if (node == null) {
            this.size += 1;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.val = val;
        } else if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else {
            node.right = put(node.right, key, val);
        }
        return node;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }
}

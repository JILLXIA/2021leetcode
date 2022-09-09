package OA.Optiver;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner input = new Scanner(System.in);
        boolean error = false;
        String str = "";
        str += input.nextLine();
        BST bst = new BST();
        // (A,B) (B,D) (D,E) (A,C) (C,F) (E,G)
        // (A,B) (A,C) (B,D) (D,C)
        for (int i = 0; i < str.length(); i = i + 5) {
            if (!(str.charAt(i) == '(' && str.charAt(i + 2) == ',' && str.charAt(i + 4) == ')')) {
                System.out.println("E1");
                error = true;
                break;
            } else {
                char p = str.charAt(i + 1);
                char c = str.charAt(i + 3);
                boolean bp = bst.exist(p);
                boolean bc = bst.exist(c);
                if (bp && bc) {
                    if (bst.findPC(p, c)) {
                        System.out.println("E2");
                        error = true;
                    } else {
                        System.out.println("E5");
                        error = true;
                    }
                    break;
                } else {
                    if (!bst.isEmpty() && !bp) {
                        System.out.println("E4");
                        error = true;
                        break;
                    } else {
                        boolean s = bst.add(p, c);
                        if (!s) {
                            System.out.println("E3");
                            error = true;
                            break;
                        }
                    }
                }
            }
            i++;
        }
        if (!error) {
            bst.preOrder();
        }
    }

    static class BSTNODE {
        char data;
        BSTNODE left;
        BSTNODE right;

        public BSTNODE(char d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }

        public void setLeft(BSTNODE node) {
            this.left = node;
        }

        public void setRight(BSTNODE node) {
            this.right = node;
        }

        public BSTNODE getLeft() {
            return this.left;
        }

        public BSTNODE getRight() {
            return this.right;
        }

        public char getData() {
            return this.data;
        }
    }

    static class BST {
        BSTNODE root;

        public BST() {
            this.root = null;
        }

        boolean exist(char ch) {
            return exist(this.root, ch);
        }

        boolean exist(BSTNODE r, char ch) {
            if (r == null) {
                return false;
            } else {
                if (r.data == ch) {
                    return true;
                } else {
                    return exist(r.right, ch) || exist(r.left, ch);
                }
            }
        }

        boolean add(char p, char c) {
            if (this.root == null) {
                this.root = new BSTNODE(p);
                if (this.root.left == null) {
                    this.root.setLeft((new BSTNODE(c)));
                } else {
                    this.root.setRight((new BSTNODE(c)));
                }
            } else {
                int r = find(this.root, p, c);
                if (r != 0) {
                    return false;
                }
            }
            return true;
        }

        int find(BSTNODE r, char ch, char c) {
            if (r == null) {
                return 0;
            } else {
                if (r.data == ch) {
                    if (r.left == null) {
                        r.left = new BSTNODE(c);
                        return 0;
                    } else {
                        if (r.right == null) {
                            r.right = new BSTNODE(c);
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                } else {
                    return (find(r.left, ch, c) + find(r.right, ch, c));
                }
            }
        }

        boolean findPC(char ch, char c) {
            int r = findPC(root, ch, c);
            if (r == 1) {
                return true;
            }
            return false;
        }


        int findPC(BSTNODE r, char ch, char c) {
            if (r == null) {
                return 0;
            } else {
                if (r.data == ch) {
                    if ((r.left != null && r.left.data == c) || (r.right != null && r.right.data == c)) {
                        return 1;
                    }
                    return 0;
                } else {
                    return (findPC(r.left, ch, c) + findPC(r.right, ch, c));
                }
            }
        }

        void preOrder() {
            preOrder(root);
        }

        void preOrder(BSTNODE r) {
            if (r == null) {
                return;
            } else {
                System.out.print("(" + r.data);
                preOrder(r.left);
                preOrder(r.right);
                System.out.print(")");
            }
        }

        boolean isEmpty() {
            return this.root == null;
        }
    }
}
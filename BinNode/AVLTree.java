package com.BinNode;
/**
 * AVL树
 *
 */
public class AVLTree<T extends Comparable<? super T>> {

	/**
	 * AVL树节点的定义
	 */
	private static class AvlNode<T> {
		AvlNode(T theElement) {
			this(theElement, null, null);
		}
		AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt) {
			element = theElement;
			left = lt;
			right = rt;
			height = 0;
		}
		T element; // 节点中的数据
		AvlNode<T> left; // 左儿子
		AvlNode<T> right; // 右儿子
		int height; // 节点的高度
	}

	// avl树根
	private AvlNode<T> root;

	public AVLTree() {
		root = null;
	}

	// 在avl树中插入数据，重复数据复略
	public void insert(T x) {
		root = insert(x, root);
	}

	// 在avl中删除数据,没有实现
	public void remove(T x) {
		System.out.println("Sorry, remove unimplemented");
	}

	// 在avl树中找最小的数据
	public T findMin() throws Exception {
		if (isEmpty())
			throw new Exception("空");
		return findMin(root).element;
	}

	// 在avl树中找最大的数据
	public T findMax() throws Exception {
		if (isEmpty())
			throw new Exception("空");
		return findMax(root).element;
	}

	// 搜索
	public boolean contains(T x) {
		return contains(x, root);
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	// 排序输出avl树
	public void printTree() {
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	
	/**
	 * AVL树的插入，重点就是这儿了
	 * @param x 要插入的元素
	 * @param t 树的根节点
	 * @return
	 */
	private AvlNode<T> insert(T x, AvlNode<T> t) {
		if (t == null){
			return new AvlNode<T>(x, null, null);
		}

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0) {
			t.left = insert(x, t.left);// 将x插入左子树中
			
			// 打破平衡
			if (height(t.left) - height(t.right) == 2){
				// LL型（左左型）
				if (x.compareTo(t.left.element) < 0){
					t = rotateWithLeftChild(t);
				}
				// LR型（左右型）
				else{
					t = doubleWithLeftChild(t);
				}
			}
				
		} else if (compareResult > 0) {
			// 将x插入右子树中
			t.right = insert(x, t.right);
			
			// 打破平衡
			if (height(t.right) - height(t.left) == 2){
				// RR型（右右型）
				if (x.compareTo(t.right.element) > 0){
					t = rotateWithRightChild(t);
				}
				else{
					// RL型
					t = doubleWithRightChild(t);
				}
			}
		} else{
			; // 重复数据，什么也不做
		}
			
		t.height = Math.max(height(t.left), height(t.right)) + 1;// 更新高度
		return t;
	}
	

	// 带左子树旋转,适用于LL型
	private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
		AvlNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		return k1;
	}

	// 带右子树旋转，适用于RR型
	private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
		AvlNode<T> k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;
		return k2;
	}

	// 双旋转，适用于LR型
	private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	// 双旋转,适用于RL型
	private AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}
	
	

	// 找最小
	private AvlNode<T> findMin(AvlNode<T> t) {
		if (t == null)
			return t;

		while (t.left != null)
			t = t.left;
		return t;
	}

	// 找最大
	private AvlNode<T> findMax(AvlNode<T> t) {
		if (t == null)
			return t;

		while (t.right != null)
			t = t.right;
		return t;
	}

	// 搜索（查找）
	private boolean contains(T x, AvlNode<T> t) {
		while (t != null) {
			int compareResult = x.compareTo(t.element);

			if (compareResult < 0)
				t = t.left;
			else if (compareResult > 0)
				t = t.right;
			else
				return true; // Match
		}

		return false; // No match
	}

	// 前序遍历avl树
	private void printTree(AvlNode<T> t) {
		if (t != null) {
			System.out.println(t.element);
			printTree(t.left);
			printTree(t.right);
		}
	}

	// 求高度
	private int height(AvlNode<T> t) {
		return t == null ? -1 : t.height;
	}


	// Test program
	public static void main(String[] args) {
		AVLTree<Integer> t = new AVLTree<Integer>();
		final int NUMS = 100;
		final int GAP = 37;

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS){
			t.insert(i);
		}
			
		t.printTree();
	}
}

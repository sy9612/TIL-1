package 개인;

public class 세그먼트트리 {
	
	static int[] a;
	public static void main(String[] args) {
		init(0, tree.length-1, 1);
	}
	static int[] tree;
	static int init(int start, int end, int node) {
		if(start == end) return tree[node] = a[start];
		int mid = (start+end) / 2;
		
		 return tree[node] = init(start,mid,node*2) + init(start,mid+1,node*2 + 1);
	}
}

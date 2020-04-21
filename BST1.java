import java.util.*;
//creating the Node
class Node{
	int data;
	Node lchild;
	Node rchild;
	public Node(int data){
		this.data=data;
		this.lchild=null;
		this.rchild=null;
	}
}
//Main class
public class BST1{
	static Node root;
	public static void main(String[] args){
		insert(30);
		insert(15);
		insert(50);
		insert(10);
		insert(20);
		insert(40);
		insert(60);
		Node n=Delete(Root(),30);
		//System.out.println(n.data);
		
		if(Root()==n)
			insert(60);
		display(Root());
	}
	//Inserting the node
	static void insert(int key){
		Node t=root;
		Node r=null;
		Node node;
		if(root==null){
			node=new Node(key);
			root=node;
			return;
		}
		while(t!=null){
			r=t;
			if(key<t.data)
				t=t.lchild;
			else if(key>t.data)
				t=t.rchild;
			else
				return;
		}
		node=new Node(key);
		if(key<r.data)
			r.lchild=node;
		else 
			r.rchild=node;
	}
	//gives the address of root node
	static Node Root(){
		return root;
	}
	// DIsplay the Binary Search tree
	public static void display(Node n){
		if(n!=null){
			display(n.lchild);
			System.out.println(n.data);
			display(n.rchild);
		}
	}
	//Gives the Height of tree
	public static int Height(Node n){
		int x,y;
		if(n==null)return 0;
		x=Height(n.lchild);
		y=Height(n.rchild);
		return x>y?x+1:y+1;
	}
	//Predecessor gives the right most element of left sub tree
	public static Node inPre(Node n){
		while((n!=null) &&(n.rchild!=null))
			n=n.rchild;
		return n;
	}
	//Successor gives the left most element of right sub tree
	public static Node inSuc(Node n){
		while((n!=null) &&(n.lchild!=null))
			n=n.lchild;
		return n;
	}
	//Delete the Node and after deleting Maintain the property of Binary search Tree
	public static Node Delete(Node n,int key){
		if(n==null)
			return null;
		if(n.lchild==null&&n.rchild==null){
			if(n==root)
				root=null;
			n=null;
			return null;
		}
		if(key>n.data)
			n.rchild=Delete(n.rchild,key);
		else if(key<n.data)
			n.lchild=Delete(n.lchild,key);
		else{
			if(Height(n.lchild)>=Height(n.rchild)){
				Node q=inPre(n.lchild);
				n.data=q.data;
				n.lchild=Delete(n.lchild,q.data);
			}else{
				Node q=inSuc(n.rchild);
				n.data=q.data;
				n.rchild=Delete(n.rchild,q.data);
			}
		}return n;
	}
}

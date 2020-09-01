package AvlTree;

public class AvlTree {
class Node{
	int data;
	int height;
	Node left,right;
	Node(int data)
	{
		this.data=data;
		this.height=1;
	}
}
private Node root=null;
void insert(int data)
{
	this.root=insert(this.root,data);
}
private Node insert(Node root,int data)
{
	if(root==null)
	{
		return new Node(data);
	}
	if(root.data<data)
	{
		root.right=insert(root.right,data);
	}
	else {
		root.left=insert(root.left,data);
	}
	root.height=Math.max(height(root.left), height(root.right))+1;
	int bf=bf(root);
	if(bf>1 && root.left.data>data)
	{	 
		 return rightRotate(root);
	}
	if(bf<-1 && root.right.data<data)
	{
		return leftRotate(root);
	}
	if(bf>1 && root.left.data<data)
	{
		root.left=leftRotate(root.left);
		return rightRotate(root);
	}
	if(bf<-1 && root.right.data>data)
	{
		root.right=rightRotate(root.right);
		return leftRotate(root);
	}
	return root;
}
private Node rightRotate(Node root)
{
	Node b=root.left;
	Node t3=b.right;
	b.right=root;
	root.left=t3;
	root.height=Math.max(height(root.left), height(root.right))+1;
	b.height=Math.max(height(b.left), height(b.right))+1;
	return b;
}
private Node leftRotate(Node c)
{
	Node b=c.right;
	Node t3=b.left;
	b.left=c;
	c.right=t3;
	c.height=Math.max(height(c.left),height(c.right))+1;
	b.height=Math.max(height(b.left), height(b.right))+1;
	return b;
}
void inorder()
{
	inorder(this.root);
}
private void inorder(Node root)
{
	if(root==null)
	{
		return;
	}
	inorder(root.left);
	if(root.left==null && root.right==null)
	{
		System.out.println(".=>"+root.data+"<=.");
	}
	else if(root.left==null)
	{
		System.out.println(".=>"+root.data+"<="+root.right.data);
	}
	else if(root.right==null)
	{
		System.out.println(root.left.data+"=>"+root.data+"<=.");
	}
	else {
		System.out.println(root.left.data+"=>"+root.data+"<="+root.right.data);
	}
	inorder(root.right);
}
int height(Node root)
{
	if(root==null)
	{
		return 0;
	}
	return root.height;
}
int bf(Node root)
{
	return height(root.left)-height(root.right);
}
}

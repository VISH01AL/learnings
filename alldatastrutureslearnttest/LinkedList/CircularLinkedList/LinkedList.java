package CircularLinkedList;

public class LinkedList {
class Node{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
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
		root=new Node(data);
		root.next=root;
		return root;
	}
	if(root.next==this.root)
	{
		Node create=new Node(data);
		Node temp=root;
		temp.next=create;
		create.next=this.root;
		return create.next;
	}
	return insert(root.next,data);
}
void print() {
	if(this.root==null)
	{
		return;
	}
	print(this.root);
	System.out.println();
}
private void print(Node root)
{
	
	if(root.next==this.root)
	{
		System.out.print(root.data);
		return;
	}
	System.out.print(root.data+" ");
	print(root.next);
}
boolean search(int data)
{
	return search(this.root,data);
}
private boolean search(Node root,int data)
{
	if(root.next==this.root)
	{
		if(root.data==data)
		{
			return true;
		}
		return false;
	}
	if(root.data==data)
	{
		return true;
	}
	return search(root.next,data);
}
void delete(int data)
{
	this.root=delete(this.root,data);
}
private Node delete(Node root,int data)
{
	if(root.data==data)
	{
		if(root.next==root)
		{
		return null;
		}
	}
	Node curr=root;
	while(curr.next!=root)
	{
		if(curr.next.data==data)
		{
	
			Node temp=curr.next;
			curr.next=temp.next;
			temp.next=null;
			return root;
		}
		curr=curr.next;
	}
	if(curr.next.data==data)
	{
		Node temp=curr.next;
		curr.next=temp.next;
		temp.next=null;
		return curr.next;
	}
	return root;
}
}

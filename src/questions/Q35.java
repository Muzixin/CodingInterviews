package questions;

import util.RandomListNode;

/**
 * @author Azreal
 *	
 *	复制复杂链表
 */
public class Q35 {

	public RandomListNode Clone(RandomListNode pHead) {
		
		CloneNodes(pHead);
		ConnectRandomNodes(pHead);
		return ReconnectNodes(pHead);
	}

	//复制原始列表的任意节点N，创建新的节点N'，并将N'加入到N的后面
	private void CloneNodes(RandomListNode pHead){
		
		RandomListNode currentNode = pHead;
		while(currentNode != null){
			RandomListNode ClonedNode = new RandomListNode(0);
			ClonedNode.label = currentNode.label;
			ClonedNode.next = currentNode.next;
			ClonedNode.random = null;
			
			currentNode.next = ClonedNode;
			currentNode = ClonedNode.next;
			
		}
	}
	
	public void ConnectRandomNodes(RandomListNode pHead){
		RandomListNode currentNode = pHead;
		while(currentNode != null){
			RandomListNode ClonedNode = currentNode.next;
			if(currentNode.random != null){
				ClonedNode.random = currentNode.random.next;
			}
			currentNode = ClonedNode.next;
		}
	}
	
	public RandomListNode ReconnectNodes(RandomListNode pHead){
		RandomListNode currentNode = pHead;
		RandomListNode ClonedHead = null;
		RandomListNode ClonedNode = null;
		if(currentNode != null){
			ClonedHead = ClonedNode = currentNode.next;
			currentNode.next = ClonedNode.next;
			currentNode = currentNode.next;
		}
		
		while(currentNode != null){
			ClonedNode.next = currentNode.next;
			ClonedNode = ClonedNode.next;
			currentNode.next = ClonedNode.next;
			currentNode = currentNode.next;
		}
		
		return ClonedHead;
	}
	
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		
		node1.random = node3;
		node2.random = node5;
		node3.random = null;
		node4.random = node2;
		node5.random = null;
		
		node4.next = node5;
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;
		
		RandomListNode root = node1;
		
		Q35 q35 = new Q35();
		RandomListNode listNode = q35.Clone(root);
		
		while(listNode != null){
			System.out.print("Label: " + listNode.label + "  Random: ");
			if(listNode.random != null)
				System.out.print(listNode.random.label + "\n");
			else {
				System.out.print("# \n");
			}
			listNode = listNode.next;
		}
			
	}
}

package questions;

import util.RandomListNode;

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
			RandomListNode ClonedNode = null;
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
			currentNode.next = currentNode.next;
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

	}
}

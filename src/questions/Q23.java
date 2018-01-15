package questions;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Q23 {
	// 两个节点相遇在环内，确定有环存在
	public ListNode MeetingNode(ListNode head) {
		if (head == null)
			return null;

		ListNode slowNode = head;
		ListNode fastNode = head;
		if (slowNode.next != null)
			fastNode = fastNode.next;
		else
			return null;

		while (fastNode.next.next != null && slowNode.next != null) {
			if (fastNode == slowNode) {
				return fastNode;
			} else {
				slowNode = slowNode.next;
				fastNode = fastNode.next.next;
			}
		}
		return null;
	}

	// 确定环内有几个节点
	public int getNuminLoop(ListNode meetingNode) {
		int num = 1;
		ListNode temp = meetingNode;
		while (temp.next != meetingNode) {
			temp = temp.next;
			num++;
		}
		return num;
	}

	// 确定环的入口节点
	public ListNode getEntryNodeofLoop(ListNode head) {
		ListNode meetingNode = MeetingNode(head);
		if (meetingNode == null)
			return null;
		int NumofLoop = getNuminLoop(meetingNode);
		ListNode fastNode = head;
		ListNode slowNode = head;
		while (NumofLoop > 0) {
			fastNode = fastNode.next;
			NumofLoop--;
		}
		while (fastNode != slowNode) {
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		return fastNode;
	}

	public static void main(String[] args){
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);
		ListNode head6 = new ListNode(6);
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = head6;
		head6.next = head3;
		
		ListNode head = head1;
		
		Q23 q23 = new Q23();
		ListNode node = q23.getEntryNodeofLoop(head);
		System.out.println(node.val);
	}
}

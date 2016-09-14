package GeneralProblems;




 public class LNode {
    public LNode next;
    public int value;
 
    public LNode(int value) {
        this.value = value;
        this.next = null;
    }
 
    @Override
    public String toString() {
 
        String data = "";
        LNode current = this;
        do {
            data += current.value + ",";
            current = current.next;
        } while (current != null);
 
        return data;
    }
}
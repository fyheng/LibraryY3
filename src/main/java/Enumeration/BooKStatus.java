package Enumeration;

public enum BooKStatus {
   AVAILABLE(1),
   BUSY(2),
   NEW(3),
   VOID(4);
   
    private final int value;
	BooKStatus(int value){
		this.value= value;
	}
}

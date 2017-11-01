package tree;

public class SortedList<T extends Comparable<? super T>> implements SortedListInterface<T>{
   private Node firstNode;
   private int numberOfEntries;
   
   public SortedList(){
      firstNode = null;
      numberOfEntries = 0;
   }
   
   @Override
   public void add(T newEntry) {
      // TODO Auto-generated method stub
      Node newNode = new Node(newEntry);
      Node nodeBefore = getNodeBefore(newEntry);
      
      if(isEmpty()||nodeBefore==null){
         newNode.setNext(firstNode);
         firstNode = newNode;
      }else{
         Node after = nodeBefore.getNext();
         newNode.setNext(after);
         nodeBefore.setNext(newNode);
      }
      numberOfEntries++;
      
   }
   
   public void addFirst(T newEntry) {
      // TODO Auto-generated method stub
      Node newNode = new Node(newEntry);
            
      newNode.setNext(firstNode);
      firstNode = newNode;
      numberOfEntries++;
      
   }
   
   private Node getNodeBefore(T anEntry){
      Node current = firstNode;
      Node before = null;
      while(current!=null && anEntry.compareTo(current.getData())>0){
         before = current;
         current = current.getNext();
      }
      return before;
   }

   @Override
   public boolean remove(T anEntry) {
      // TODO Auto-generated method stub
      int position = getPosition(anEntry);
      if(position<0)
         return false;
      else remove(position);
      
      return true;
   }

   @Override
   public int getPosition(T anEntry) {
      // TODO Auto-generated method stub
      boolean found = false;
      int count = 1;
      Node current = firstNode;
      
      while(!found && count<=numberOfEntries){
         if(anEntry.compareTo(current.getData())==0){
            found = true;
            return count;
         }else {
            current = current.getNext();
            count++;
         }//if close
      }//while close
      return -1;
   }

   @Override
   public T getEntry(int givenPosition) {
      // TODO Auto-generated method stub
      T result = getNodeAt(givenPosition).getData();
      return result;
   }
   
   private Node getNodeAt(int position){
      assert firstNode!=null && position>=1 && position<=numberOfEntries;
      if( (position>=1) && (position<=numberOfEntries)){
         Node current = firstNode;
         for(int i=1; i<position; i++){
            current = current.getNext();
         }
         return current;
      }else return null;
   }

   @Override
   public boolean contains(T anEntry) {
      // TODO Auto-generated method stub
      boolean result = true;
      int position = getPosition(anEntry);
      if(position<0){
         return false;
      }
      return result;
   }

   @Override
   public T remove(int givenPosition) {
      // TODO Auto-generated method stub
      T result = null;
      if( (givenPosition>=1) && (givenPosition<=numberOfEntries)){
         result = firstNode.getData();
         firstNode = firstNode.getNext();
      }else{
         Node before = getNodeAt(givenPosition-1);
         Node remove = before.getNext();
         Node after = remove.getNext();
         before.setNext(after);
         result = remove.getData();
      }
      numberOfEntries--;
      return result;
   }

   @Override
   public void clear() {
      // TODO Auto-generated method stub
      firstNode = null;
      numberOfEntries = 0;
   }

   @Override
   public int getLength() {
      // TODO Auto-generated method stub
      return numberOfEntries;
   }

   @Override
   public boolean isEmpty() {
      // TODO Auto-generated method stub
      boolean result = false;
      if(numberOfEntries==0){
         if(firstNode==null){
            result = true;
         }
      }
      return result;
   }

   @Override
   public T[] toArray() {
      // TODO Auto-generated method stub
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Comparable[numberOfEntries];

      Node currentNode=firstNode;
      int index=0;
      while(index<numberOfEntries&&currentNode!=null)
      {
         result[index] = currentNode.getData();
         currentNode = currentNode.getNext();
         index++;
      }
      
      return result;
   }
   
   private class Node{
      private T data;
      private Node next;
      
      private Node(T dataPortion, Node node){
         this.data = dataPortion;
         this.next = node;
      }
      
      private Node(T dataPortion){
         this.data = dataPortion;
      }

      public T getData() {
         return data;
      }

      public void setData(T data) {
         this.data = data;
      }

      public Node getNext() {
         return next;
      }

      public void setNext(Node next) {
         this.next = next;
      }
      
   }
   
}
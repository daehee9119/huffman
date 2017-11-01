package tree;

import java.util.Iterator;

public class HuffmanCode<T> extends BinaryTree<T>{
   
   private HuffmanTree<DataStorage> hTree;
   private SortedList<DataStorage> sl;
   
   public HuffmanCode()
   {
      sl = new SortedList<DataStorage>();
      hTree = new HuffmanTree<DataStorage>();
   }

   public String decoding(String str){
      String decode = str;
      char[] decryption = str.toCharArray();
      BinaryNode<DataStorage> ds = (BinaryNode<DataStorage>)hTree.getRootNode();
      
      for(int i=0;i<decryption.length;i++){
         if(decryption[i]=='0'){
            ds = (BinaryNode<DataStorage>)ds.getLeftChild();
         }else if(decryption[i]=='1'){
            ds = (BinaryNode<DataStorage>)ds.getRightChild();
         }else {
            decode = decode+ds.getData().getStr();
            ds = (BinaryNode<DataStorage>)hTree.getRootNode();
         }
      }//for close
      return decode;
   }
   
   public String encoding(String str){
      String encode = str;
      char[] ch = str.toCharArray();
      System.out.println("길이체크");
      System.out.println(str.length()+"="+ch.length);
      int[] frequency = countFrequency(ch);//빈도 체크
      String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
      //setPriority(frequency, alpha);//abc 빈도순 정렬
      for(int i=0;i<alpha.length;i++){
          sl.add(new DataStorage(alpha[i],frequency[i]));
      }
      //여기까지 sortedList 채워넣기
      
      hTree = setHuffmanTree(sl);
      //트리로 옮긴다.
      Iterator it =   hTree.getInorderIterator();
      while(it.hasNext())
      {
         @SuppressWarnings("unchecked")
		BinaryNode<DataStorage> current =  (BinaryNode<DataStorage>) it.next();
         String currentStr = null;
         if(current.isLeaf()){
            currentStr = current.getData().getStr();
            String temp = hTree.setEncode(current);
            encode = encode.replaceAll(currentStr, temp);
         }//if close
      }//while close
      return encode;
      
      
      
     
      
      
   }
   
   private HuffmanTree<DataStorage> setHuffmanTree(SortedList<DataStorage> list){
      BinaryNode<DataStorage> prev = new BinaryNode<DataStorage>();
      HuffmanTree<DataStorage> tempTree = new HuffmanTree<DataStorage>();
      
      
      for(int i=0;i<list.getLength();i++){
         System.out.println(list.getEntry(i+1).getStr());
      }

      int count = 0;
      while(!list.isEmpty()&&(list.getLength()>1)){
         DataStorage first=null;
         DataStorage second=null;
         
         first=list.remove(1);
         second=list.remove(1);
         
         
         System.out.println(count+"번째 first="+first.getStr()+"   "+first.getFreq()+"\n   second="+second.getStr()+"   "+second.getFreq());      

         int sum = first.getFreq()+second.getFreq();
         DataStorage root = new DataStorage("*"+count,sum);
         list.addFirst(root);
         
         if(tempTree.isEmpty()){
            tempTree.setTree(root, new BinaryTree<DataStorage>(first),new BinaryTree<DataStorage>(second));
         }else if( (first.getStr().equals("*")) && (second.getStr()!=null)){
            tempTree.setTree(root);
            tempTree.setLeftChild(prev);
            tempTree.setRightChild(new BinaryNode<DataStorage>(second));
         }else if( (first.getStr()!=null) && (second.getStr().equals("*"))){
            tempTree.setTree(root);
            tempTree.setLeftChild(new BinaryNode<DataStorage>(first));
            tempTree.setRightChild(prev);
         }/*else if( (first.getStr()!=null) && (second.getStr()!=null)){
            HuffmanTree<DataStorage> tempTree2 = new HuffmanTree<DataStorage>();
            tempTree2.setTree(root, new BinaryTree<DataStorage>(first), new BinaryTree<DataStorage>(second));

            int tempSum = tempTree2.getRootData().getFreq()+ tempTree.getRootData().getFreq();

            list.remove(root);
            root = new DataStorage("*",tempSum);
            prev = (BinaryNode<DataStorage>) tempTree.getRootNode();
            tempTree.setTree(root);
            tempTree.setLeftChild(prev);
            tempTree.setRightChild(tempTree2.getRootNode().getRightChild());

         }*/else if( (first.getStr()!=null) && (second.getStr()==null)){
            tempTree.setRightChild(prev.getRightChild());
         }
         
         prev = (BinaryNode<DataStorage>)tempTree.getRootNode();
         count++;
      }//while close
      
      return tempTree;
   }
   
   
   public int[] countFrequency(char[] ch){
      
      int[] count = new int[26];
      for(int i=0;i<ch.length;i++){
         char alpha = ch[i];
         switch(alpha){
         case 'a':
            count[0]++;
            break;
         case 'b':
            count[1]++;
            break;
         case 'c':
            count[2]++;
            break;
         case 'd':
            count[3]++;
            break;
         case 'e':
            count[4]++;
            break;
         case 'f':
            count[5]++;
            break;
         case 'g':
            count[6]++;
            break;
         case 'h':
            count[7]++;
            break;
         case 'i':
            count[8]++;
            break;
         case 'j':
            count[9]++;
            break;
         case 'k':
            count[10]++;
            break;
         case 'l':
            count[11]++;
            break;
         case 'm':
            count[12]++;
            break;
         case 'n':
            count[13]++;
            break;
         case 'o':
            count[14]++;
            break;
         case 'p':
            count[15]++;
            break;
         case 'q':
            count[16]++;
            break;
         case 'r':
            count[17]++;
            break;
         case 's':
            count[18]++;
            break;
         case 't':
            count[19]++;
            break;
         case 'u':
            count[20]++;
            break;
         case 'v':
            count[21]++;
            break;
         case 'w':
            count[22]++;
            break;
         case 'x':
            count[23]++;
            break;
         case 'y':
            count[24]++;
            break;
         case 'z':
            count[25]++;
            break;
         }//switch end
      }//for end g

         
      return count;
   }//count end
   
}
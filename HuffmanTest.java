package tree;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HuffmanTest {
	public static void main(String[] args){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		String str = "fuckingdatastructuresandabstractionwithjavatm";
		HuffmanCode hc = new HuffmanCode();
		String encoding = hc.encoding(str);
		System.out.println(encoding);
		
		
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitestatediagram;

import java.util.ArrayList;

/**
 *
 * @author Thien
 */
public class GenerateDiagram {
    public static ArrayList<StateNode> nodelist;
   public static void findDiagram(String input){
       nodelist = new ArrayList<>();
       //init number of node
        for (int i=0;i<input.length()+1;i++){
            StateNode newNode = new StateNode("q"+Integer.toString(i));
            nodelist.add(newNode);
        }
        
        for (int i=0;i<input.length();i++){
            
           if (input.charAt(i)=='0'){
               nodelist.get(i).zero = nodelist.get(i+1);
               nodelist.get(i).one = null;
              if (input.charAt(0)=='0'){
                  nodelist.get(i).one = nodelist.get(0);
              }
              else{
              for (int a = 0;a<i;a++){
                  if (input.charAt(a)=='1'){
                  nodelist.get(i).one = nodelist.get(a+1);//back to a
                  break;
                  }
              }    
              }
           };
           if (input.charAt(i)=='1'){
               nodelist.get(i).one = nodelist.get(i+1);
               nodelist.get(i).zero = null;
               if (input.charAt(0)=='1'){
                  nodelist.get(i).zero = nodelist.get(0);
              } else{
              for (int a = 0;a<i;a++){
                  if (input.charAt(a)=='0'){
                  nodelist.get(i).zero = nodelist.get(a+1);//back to a
                  break;
                  }
              }    
              }
           };
        }
        
    }
   
   public static void outputdiagram(){
       for (int i=0;i<nodelist.size();i++){
          StateNode cur = nodelist.get(i);
          
          System.out.print("Current : "+cur.id+"\n");
          
          if (cur.one!=null){
          StateNode one = cur.one;
          System.out.print("One : "+one.id+"\n");
          }
          if (cur.zero!=null){
          StateNode zero = cur.zero;
          System.out.print("Zero : "+zero.id+"\n");
          }
          System.out.println();
       }
   }
}

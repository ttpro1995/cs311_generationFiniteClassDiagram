/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitestatediagram;

/**
 *
 * @author Thien
 */
public class StateNode {
    public String id;
    public StateNode zero;
    public StateNode one;

    public StateNode(String id) {
        this.id = id;
        zero = null;
        one = null;
    }
    
}

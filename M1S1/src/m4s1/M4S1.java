/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m4s1;

import itpm.Main;

/**
 *
 * @author Roshan Withanage
 */
public class M4S1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main obj = new Main();
        obj.setVisible(true);
        obj.setExtendedState(obj.getExtendedState() | obj.MAXIMIZED_BOTH);
    }

}

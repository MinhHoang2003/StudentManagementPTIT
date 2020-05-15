/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.WindowAdapter;

/**
 *
 * @author PhamMinhHoang
 */
public interface BaseController {

    void show(boolean isVisible);

    void refreshTable();

    void onWindowClosed(WindowAdapter windowAdapter);
    
    void showConfirmCloseMessage();
}

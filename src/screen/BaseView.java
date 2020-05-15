/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.util.List;

/**
 *
 * @author PhamMinhHoang
 * @param <T>
 */
public interface BaseView<T> {

    void setVisible(boolean isVisible);

    void refreshTable(List<T> data);

    void showErrorMessage(String message);

    void showConfirmCloseMessage();
}

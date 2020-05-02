/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author PhamMinhHoang
 * @param <T>: return type of get data function
 */
public interface DataLoadingListener<T> {
    void onGetDataSuccess(T data);
    void onGetDataFailure(String messaage);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.repository;

/**
 *
 * @author hoang
 */
public interface LocalTaskListener<T> {

    public void onTaskDone(T data);

    public void onTaskError(String message);
}

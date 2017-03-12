package com.alegerd.Ochko.Interfaces;

/**
 * Created by alegerd on 12.03.17.
 */
public interface Observable<T> {
    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObserver(int whatToDo);
}

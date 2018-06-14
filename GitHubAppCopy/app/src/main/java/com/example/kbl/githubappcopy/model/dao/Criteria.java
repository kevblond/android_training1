package com.example.kbl.githubappcopy.model.dao;
/**
 * Criteria class
 * @param <T> the value
 */
public class Criteria<T> {
    /**
     * Column name
     */
    private String field;
    /**
     * Value of the column
     */
    private T value;

    /**********************************************************************************************/
    /***                               Getters & setters                                        ***/
    /**********************************************************************************************/
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

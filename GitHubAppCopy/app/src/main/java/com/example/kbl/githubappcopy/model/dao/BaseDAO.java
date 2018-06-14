package com.example.kbl.githubappcopy.model.dao;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * BaseDAO class
 *
 * @param <T> the realmobject associated
 */
public class BaseDAO<T extends RealmObject> {
    /**
     * Constantes
     */
    private static final String ID = "id";
    /**
     * Type de la classe
     */
    protected final Class<T> typeParameterClass;

    /**
     * constructor
     *
     * @param clazz the class associated
     */
    public BaseDAO(Class<T> clazz) {
        this.typeParameterClass = clazz;
    }

    /**
     * Inserts or updates the given object in database
     *
     * @param obj object to save in DB
     * @return the managed object if create request succeeds
     */
    public void insertOrUpdate(final T obj) {
        executeOperation(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(obj);
            }
        });
    }

    /**
     * Inserts or updates the given object list in database
     *
     * @param objList object list to save in DB
     * @return the managed object list if create request succeeds
     */
    public void insertOrUpdateAll(final List<T> objList) {
        executeOperation(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(objList);
            }
        });
    }

    /**
     * Delete the given object in database
     *
     * @param primaryKey to look for
     */
    public void delete(final String primaryKey) {
        executeOperation(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                performFindQuery(realm, primaryKey).deleteFromRealm();
            }
        });
    }

    /**
     * Delete all tablee
     */
    public void deleteAll() {
        executeOperation(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(typeParameterClass);
            }
        });
    }

    /**
     * Find any object with its primary key
     *
     * @param primaryKey Primary key of the needed object
     * @return The object if it was found in DB
     */
    public T find(final String primaryKey) {
        final Holder<T> holder = new Holder<>();
        executeOperation(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                holder.value = performFindQuery(realm, primaryKey);

                if (holder.value != null) {
                    holder.value = realm.copyFromRealm(holder.value);
                }
            }
        });

        return holder.value;
    }

    /**
     * Find all objects
     *
     * @return all objects of the given type
     */
    public List<T> findAll() {
        final Holder<List<T>> holder = new Holder<>();
        executeOperation(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                holder.value = realm.where(typeParameterClass).findAll();

                if (holder.value != null) {
                    holder.value = realm.copyFromRealm(holder.value);
                }
            }
        });

        return holder.value;
    }

    /**
     * Find all objects with criteria
     *
     * @param criteria the criteria
     * @return all objects of the given criteria
     */
    public List<T> find(final Criteria criteria) {
        if (criteria.getValue() instanceof String) {
            return findByField(criteria.getField(), (String) criteria.getValue());
        } else if (criteria.getValue() instanceof Long) {
            return findByField(criteria.getField(), (Long) criteria.getValue());
        } else if (criteria.getValue() instanceof Boolean) {
            return findByField(criteria.getField(), (Boolean) criteria.getValue());
        } else {
            throw new IllegalStateException("The criteria's value should be of the following type: String, Long, Boolean");
        }
    }

    private List<T> findByField(final String field, final String value) {
        final Holder<List<T>> holder = new Holder<>();
        executeOperation(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                holder.value = realm.where(typeParameterClass).equalTo(field, value).findAll();

                if (holder.value != null) {
                    holder.value = realm.copyFromRealm(holder.value);
                }
            }
        });

        return holder.value;
    }

    private List<T> findByField(final String field, final boolean value) {
        final Holder<List<T>> holder = new Holder<>();
        executeOperation(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                holder.value = realm.where(typeParameterClass).equalTo(field, value).findAll();

                if (holder.value != null) {
                    holder.value = realm.copyFromRealm(holder.value);
                }
            }
        });

        return holder.value;
    }

    private List<T> findByField(final String field, final long value) {
        final Holder<List<T>> holder = new Holder<>();
        executeOperation(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                holder.value = realm.where(typeParameterClass).equalTo(field, value).findAll();

                if (holder.value != null) {
                    holder.value = realm.copyFromRealm(holder.value);
                }
            }
        });

        return holder.value;
    }

    /**
     * Executes an operation.
     *
     * @param operation to execute.
     */
    protected final void executeOperation(Realm.Transaction operation) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(operation);
        realm.close();
    }

    protected T performFindQuery(Realm realm, String id) {
        return realm.where(typeParameterClass).equalTo(ID, id).findFirst();
    }

    protected static final class Holder<V> {
        /**
         * the value
         */
        public V value;
    }
}
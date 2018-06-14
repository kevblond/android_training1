package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_kbl_githubappcopy_model_RepositorieRealmProxy extends com.example.kbl.githubappcopy.model.Repositorie
    implements RealmObjectProxy, com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface {

    static final class RepositorieColumnInfo extends ColumnInfo {
        long idIndex;
        long ownerIndex;
        long descriptionIndex;
        long nameIndex;
        long full_nameIndex;
        long watchersIndex;
        long languageIndex;

        RepositorieColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Repositorie");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.ownerIndex = addColumnDetails("owner", "owner", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.full_nameIndex = addColumnDetails("full_name", "full_name", objectSchemaInfo);
            this.watchersIndex = addColumnDetails("watchers", "watchers", objectSchemaInfo);
            this.languageIndex = addColumnDetails("language", "language", objectSchemaInfo);
        }

        RepositorieColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RepositorieColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RepositorieColumnInfo src = (RepositorieColumnInfo) rawSrc;
            final RepositorieColumnInfo dst = (RepositorieColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.ownerIndex = src.ownerIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.nameIndex = src.nameIndex;
            dst.full_nameIndex = src.full_nameIndex;
            dst.watchersIndex = src.watchersIndex;
            dst.languageIndex = src.languageIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RepositorieColumnInfo columnInfo;
    private ProxyState<com.example.kbl.githubappcopy.model.Repositorie> proxyState;

    com_example_kbl_githubappcopy_model_RepositorieRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RepositorieColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.kbl.githubappcopy.model.Repositorie>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    public com.example.kbl.githubappcopy.model.Owner realmGet$owner() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.ownerIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.kbl.githubappcopy.model.Owner.class, proxyState.getRow$realm().getLink(columnInfo.ownerIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$owner(com.example.kbl.githubappcopy.model.Owner value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("owner")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.ownerIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.ownerIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.ownerIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.ownerIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$full_name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.full_nameIndex);
    }

    @Override
    public void realmSet$full_name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.full_nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.full_nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.full_nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.full_nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$watchers() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.watchersIndex);
    }

    @Override
    public void realmSet$watchers(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.watchersIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.watchersIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$language() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.languageIndex);
    }

    @Override
    public void realmSet$language(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.languageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.languageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.languageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.languageIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Repositorie", 7, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("owner", RealmFieldType.OBJECT, "Owner");
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("full_name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("watchers", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("language", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RepositorieColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RepositorieColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Repositorie";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Repositorie";
    }

    @SuppressWarnings("cast")
    public static com.example.kbl.githubappcopy.model.Repositorie createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.example.kbl.githubappcopy.model.Repositorie obj = null;
        if (update) {
            Table table = realm.getTable(com.example.kbl.githubappcopy.model.Repositorie.class);
            RepositorieColumnInfo columnInfo = (RepositorieColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Repositorie.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Repositorie.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_kbl_githubappcopy_model_RepositorieRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("owner")) {
                excludeFields.add("owner");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_example_kbl_githubappcopy_model_RepositorieRealmProxy) realm.createObjectInternal(com.example.kbl.githubappcopy.model.Repositorie.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_kbl_githubappcopy_model_RepositorieRealmProxy) realm.createObjectInternal(com.example.kbl.githubappcopy.model.Repositorie.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface objProxy = (com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) obj;
        if (json.has("owner")) {
            if (json.isNull("owner")) {
                objProxy.realmSet$owner(null);
            } else {
                com.example.kbl.githubappcopy.model.Owner ownerObj = com_example_kbl_githubappcopy_model_OwnerRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("owner"), update);
                objProxy.realmSet$owner(ownerObj);
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("full_name")) {
            if (json.isNull("full_name")) {
                objProxy.realmSet$full_name(null);
            } else {
                objProxy.realmSet$full_name((String) json.getString("full_name"));
            }
        }
        if (json.has("watchers")) {
            if (json.isNull("watchers")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'watchers' to null.");
            } else {
                objProxy.realmSet$watchers((int) json.getInt("watchers"));
            }
        }
        if (json.has("language")) {
            if (json.isNull("language")) {
                objProxy.realmSet$language(null);
            } else {
                objProxy.realmSet$language((String) json.getString("language"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.kbl.githubappcopy.model.Repositorie createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.kbl.githubappcopy.model.Repositorie obj = new com.example.kbl.githubappcopy.model.Repositorie();
        final com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface objProxy = (com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("owner")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$owner(null);
                } else {
                    com.example.kbl.githubappcopy.model.Owner ownerObj = com_example_kbl_githubappcopy_model_OwnerRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$owner(ownerObj);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("full_name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$full_name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$full_name(null);
                }
            } else if (name.equals("watchers")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$watchers((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'watchers' to null.");
                }
            } else if (name.equals("language")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$language((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$language(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.example.kbl.githubappcopy.model.Repositorie copyOrUpdate(Realm realm, com.example.kbl.githubappcopy.model.Repositorie object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.kbl.githubappcopy.model.Repositorie) cachedRealmObject;
        }

        com.example.kbl.githubappcopy.model.Repositorie realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.kbl.githubappcopy.model.Repositorie.class);
            RepositorieColumnInfo columnInfo = (RepositorieColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Repositorie.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Repositorie.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_kbl_githubappcopy_model_RepositorieRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.example.kbl.githubappcopy.model.Repositorie copy(Realm realm, com.example.kbl.githubappcopy.model.Repositorie newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.kbl.githubappcopy.model.Repositorie) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.kbl.githubappcopy.model.Repositorie realmObject = realm.createObjectInternal(com.example.kbl.githubappcopy.model.Repositorie.class, ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface realmObjectSource = (com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) newObject;
        com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface realmObjectCopy = (com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) realmObject;


        com.example.kbl.githubappcopy.model.Owner ownerObj = realmObjectSource.realmGet$owner();
        if (ownerObj == null) {
            realmObjectCopy.realmSet$owner(null);
        } else {
            com.example.kbl.githubappcopy.model.Owner cacheowner = (com.example.kbl.githubappcopy.model.Owner) cache.get(ownerObj);
            if (cacheowner != null) {
                realmObjectCopy.realmSet$owner(cacheowner);
            } else {
                realmObjectCopy.realmSet$owner(com_example_kbl_githubappcopy_model_OwnerRealmProxy.copyOrUpdate(realm, ownerObj, update, cache));
            }
        }
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$full_name(realmObjectSource.realmGet$full_name());
        realmObjectCopy.realmSet$watchers(realmObjectSource.realmGet$watchers());
        realmObjectCopy.realmSet$language(realmObjectSource.realmGet$language());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.kbl.githubappcopy.model.Repositorie object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.kbl.githubappcopy.model.Repositorie.class);
        long tableNativePtr = table.getNativePtr();
        RepositorieColumnInfo columnInfo = (RepositorieColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Repositorie.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);

        com.example.kbl.githubappcopy.model.Owner ownerObj = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$owner();
        if (ownerObj != null) {
            Long cacheowner = cache.get(ownerObj);
            if (cacheowner == null) {
                cacheowner = com_example_kbl_githubappcopy_model_OwnerRealmProxy.insert(realm, ownerObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.ownerIndex, rowIndex, cacheowner, false);
        }
        String realmGet$description = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$name = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$full_name = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$full_name();
        if (realmGet$full_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.full_nameIndex, rowIndex, realmGet$full_name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.watchersIndex, rowIndex, ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$watchers(), false);
        String realmGet$language = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$language();
        if (realmGet$language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.kbl.githubappcopy.model.Repositorie.class);
        long tableNativePtr = table.getNativePtr();
        RepositorieColumnInfo columnInfo = (RepositorieColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Repositorie.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.kbl.githubappcopy.model.Repositorie object = null;
        while (objects.hasNext()) {
            object = (com.example.kbl.githubappcopy.model.Repositorie) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);

            com.example.kbl.githubappcopy.model.Owner ownerObj = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$owner();
            if (ownerObj != null) {
                Long cacheowner = cache.get(ownerObj);
                if (cacheowner == null) {
                    cacheowner = com_example_kbl_githubappcopy_model_OwnerRealmProxy.insert(realm, ownerObj, cache);
                }
                table.setLink(columnInfo.ownerIndex, rowIndex, cacheowner, false);
            }
            String realmGet$description = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            String realmGet$name = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$full_name = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$full_name();
            if (realmGet$full_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.full_nameIndex, rowIndex, realmGet$full_name, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.watchersIndex, rowIndex, ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$watchers(), false);
            String realmGet$language = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$language();
            if (realmGet$language != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.kbl.githubappcopy.model.Repositorie object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.kbl.githubappcopy.model.Repositorie.class);
        long tableNativePtr = table.getNativePtr();
        RepositorieColumnInfo columnInfo = (RepositorieColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Repositorie.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);

        com.example.kbl.githubappcopy.model.Owner ownerObj = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$owner();
        if (ownerObj != null) {
            Long cacheowner = cache.get(ownerObj);
            if (cacheowner == null) {
                cacheowner = com_example_kbl_githubappcopy_model_OwnerRealmProxy.insertOrUpdate(realm, ownerObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.ownerIndex, rowIndex, cacheowner, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.ownerIndex, rowIndex);
        }
        String realmGet$description = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$name = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$full_name = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$full_name();
        if (realmGet$full_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.full_nameIndex, rowIndex, realmGet$full_name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.full_nameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.watchersIndex, rowIndex, ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$watchers(), false);
        String realmGet$language = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$language();
        if (realmGet$language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.languageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.kbl.githubappcopy.model.Repositorie.class);
        long tableNativePtr = table.getNativePtr();
        RepositorieColumnInfo columnInfo = (RepositorieColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Repositorie.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.kbl.githubappcopy.model.Repositorie object = null;
        while (objects.hasNext()) {
            object = (com.example.kbl.githubappcopy.model.Repositorie) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);

            com.example.kbl.githubappcopy.model.Owner ownerObj = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$owner();
            if (ownerObj != null) {
                Long cacheowner = cache.get(ownerObj);
                if (cacheowner == null) {
                    cacheowner = com_example_kbl_githubappcopy_model_OwnerRealmProxy.insertOrUpdate(realm, ownerObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.ownerIndex, rowIndex, cacheowner, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.ownerIndex, rowIndex);
            }
            String realmGet$description = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            String realmGet$name = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$full_name = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$full_name();
            if (realmGet$full_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.full_nameIndex, rowIndex, realmGet$full_name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.full_nameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.watchersIndex, rowIndex, ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$watchers(), false);
            String realmGet$language = ((com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) object).realmGet$language();
            if (realmGet$language != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.languageIndex, rowIndex, false);
            }
        }
    }

    public static com.example.kbl.githubappcopy.model.Repositorie createDetachedCopy(com.example.kbl.githubappcopy.model.Repositorie realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.kbl.githubappcopy.model.Repositorie unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.kbl.githubappcopy.model.Repositorie();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.kbl.githubappcopy.model.Repositorie) cachedObject.object;
            }
            unmanagedObject = (com.example.kbl.githubappcopy.model.Repositorie) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface unmanagedCopy = (com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) unmanagedObject;
        com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface realmSource = (com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());

        // Deep copy of owner
        unmanagedCopy.realmSet$owner(com_example_kbl_githubappcopy_model_OwnerRealmProxy.createDetachedCopy(realmSource.realmGet$owner(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$full_name(realmSource.realmGet$full_name());
        unmanagedCopy.realmSet$watchers(realmSource.realmGet$watchers());
        unmanagedCopy.realmSet$language(realmSource.realmGet$language());

        return unmanagedObject;
    }

    static com.example.kbl.githubappcopy.model.Repositorie update(Realm realm, com.example.kbl.githubappcopy.model.Repositorie realmObject, com.example.kbl.githubappcopy.model.Repositorie newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface realmObjectTarget = (com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) realmObject;
        com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface realmObjectSource = (com_example_kbl_githubappcopy_model_RepositorieRealmProxyInterface) newObject;
        com.example.kbl.githubappcopy.model.Owner ownerObj = realmObjectSource.realmGet$owner();
        if (ownerObj == null) {
            realmObjectTarget.realmSet$owner(null);
        } else {
            com.example.kbl.githubappcopy.model.Owner cacheowner = (com.example.kbl.githubappcopy.model.Owner) cache.get(ownerObj);
            if (cacheowner != null) {
                realmObjectTarget.realmSet$owner(cacheowner);
            } else {
                realmObjectTarget.realmSet$owner(com_example_kbl_githubappcopy_model_OwnerRealmProxy.copyOrUpdate(realm, ownerObj, true, cache));
            }
        }
        realmObjectTarget.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$full_name(realmObjectSource.realmGet$full_name());
        realmObjectTarget.realmSet$watchers(realmObjectSource.realmGet$watchers());
        realmObjectTarget.realmSet$language(realmObjectSource.realmGet$language());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Repositorie = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{owner:");
        stringBuilder.append(realmGet$owner() != null ? "Owner" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{full_name:");
        stringBuilder.append(realmGet$full_name() != null ? realmGet$full_name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{watchers:");
        stringBuilder.append(realmGet$watchers());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{language:");
        stringBuilder.append(realmGet$language() != null ? realmGet$language() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_kbl_githubappcopy_model_RepositorieRealmProxy aRepositorie = (com_example_kbl_githubappcopy_model_RepositorieRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRepositorie.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRepositorie.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRepositorie.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}

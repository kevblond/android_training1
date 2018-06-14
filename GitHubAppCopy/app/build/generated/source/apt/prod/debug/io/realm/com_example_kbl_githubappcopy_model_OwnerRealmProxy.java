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
public class com_example_kbl_githubappcopy_model_OwnerRealmProxy extends com.example.kbl.githubappcopy.model.Owner
    implements RealmObjectProxy, com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface {

    static final class OwnerColumnInfo extends ColumnInfo {
        long idIndex;
        long loginIndex;
        long avatar_urlIndex;
        long public_reposIndex;

        OwnerColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Owner");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.loginIndex = addColumnDetails("login", "login", objectSchemaInfo);
            this.avatar_urlIndex = addColumnDetails("avatar_url", "avatar_url", objectSchemaInfo);
            this.public_reposIndex = addColumnDetails("public_repos", "public_repos", objectSchemaInfo);
        }

        OwnerColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new OwnerColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final OwnerColumnInfo src = (OwnerColumnInfo) rawSrc;
            final OwnerColumnInfo dst = (OwnerColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.loginIndex = src.loginIndex;
            dst.avatar_urlIndex = src.avatar_urlIndex;
            dst.public_reposIndex = src.public_reposIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private OwnerColumnInfo columnInfo;
    private ProxyState<com.example.kbl.githubappcopy.model.Owner> proxyState;

    com_example_kbl_githubappcopy_model_OwnerRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (OwnerColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.kbl.githubappcopy.model.Owner>(this);
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
    @SuppressWarnings("cast")
    public String realmGet$login() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.loginIndex);
    }

    @Override
    public void realmSet$login(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.loginIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.loginIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.loginIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.loginIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$avatar_url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.avatar_urlIndex);
    }

    @Override
    public void realmSet$avatar_url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.avatar_urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.avatar_urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.avatar_urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.avatar_urlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$public_repos() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.public_reposIndex);
    }

    @Override
    public void realmSet$public_repos(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.public_reposIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.public_reposIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.public_reposIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.public_reposIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Owner", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("login", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("avatar_url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("public_repos", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static OwnerColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new OwnerColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Owner";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Owner";
    }

    @SuppressWarnings("cast")
    public static com.example.kbl.githubappcopy.model.Owner createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.kbl.githubappcopy.model.Owner obj = null;
        if (update) {
            Table table = realm.getTable(com.example.kbl.githubappcopy.model.Owner.class);
            OwnerColumnInfo columnInfo = (OwnerColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Owner.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Owner.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_kbl_githubappcopy_model_OwnerRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_example_kbl_githubappcopy_model_OwnerRealmProxy) realm.createObjectInternal(com.example.kbl.githubappcopy.model.Owner.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_kbl_githubappcopy_model_OwnerRealmProxy) realm.createObjectInternal(com.example.kbl.githubappcopy.model.Owner.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface objProxy = (com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) obj;
        if (json.has("login")) {
            if (json.isNull("login")) {
                objProxy.realmSet$login(null);
            } else {
                objProxy.realmSet$login((String) json.getString("login"));
            }
        }
        if (json.has("avatar_url")) {
            if (json.isNull("avatar_url")) {
                objProxy.realmSet$avatar_url(null);
            } else {
                objProxy.realmSet$avatar_url((String) json.getString("avatar_url"));
            }
        }
        if (json.has("public_repos")) {
            if (json.isNull("public_repos")) {
                objProxy.realmSet$public_repos(null);
            } else {
                objProxy.realmSet$public_repos((String) json.getString("public_repos"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.kbl.githubappcopy.model.Owner createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.kbl.githubappcopy.model.Owner obj = new com.example.kbl.githubappcopy.model.Owner();
        final com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface objProxy = (com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) obj;
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
            } else if (name.equals("login")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$login((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$login(null);
                }
            } else if (name.equals("avatar_url")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$avatar_url((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$avatar_url(null);
                }
            } else if (name.equals("public_repos")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$public_repos((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$public_repos(null);
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

    public static com.example.kbl.githubappcopy.model.Owner copyOrUpdate(Realm realm, com.example.kbl.githubappcopy.model.Owner object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.kbl.githubappcopy.model.Owner) cachedRealmObject;
        }

        com.example.kbl.githubappcopy.model.Owner realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.kbl.githubappcopy.model.Owner.class);
            OwnerColumnInfo columnInfo = (OwnerColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Owner.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Owner.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_kbl_githubappcopy_model_OwnerRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.example.kbl.githubappcopy.model.Owner copy(Realm realm, com.example.kbl.githubappcopy.model.Owner newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.kbl.githubappcopy.model.Owner) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.kbl.githubappcopy.model.Owner realmObject = realm.createObjectInternal(com.example.kbl.githubappcopy.model.Owner.class, ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface realmObjectSource = (com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) newObject;
        com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface realmObjectCopy = (com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$login(realmObjectSource.realmGet$login());
        realmObjectCopy.realmSet$avatar_url(realmObjectSource.realmGet$avatar_url());
        realmObjectCopy.realmSet$public_repos(realmObjectSource.realmGet$public_repos());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.kbl.githubappcopy.model.Owner object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.kbl.githubappcopy.model.Owner.class);
        long tableNativePtr = table.getNativePtr();
        OwnerColumnInfo columnInfo = (OwnerColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Owner.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$id();
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
        String realmGet$login = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        }
        String realmGet$avatar_url = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$avatar_url();
        if (realmGet$avatar_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatar_urlIndex, rowIndex, realmGet$avatar_url, false);
        }
        String realmGet$public_repos = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$public_repos();
        if (realmGet$public_repos != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.public_reposIndex, rowIndex, realmGet$public_repos, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.kbl.githubappcopy.model.Owner.class);
        long tableNativePtr = table.getNativePtr();
        OwnerColumnInfo columnInfo = (OwnerColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Owner.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.kbl.githubappcopy.model.Owner object = null;
        while (objects.hasNext()) {
            object = (com.example.kbl.githubappcopy.model.Owner) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$id();
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
            String realmGet$login = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            }
            String realmGet$avatar_url = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$avatar_url();
            if (realmGet$avatar_url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatar_urlIndex, rowIndex, realmGet$avatar_url, false);
            }
            String realmGet$public_repos = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$public_repos();
            if (realmGet$public_repos != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.public_reposIndex, rowIndex, realmGet$public_repos, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.kbl.githubappcopy.model.Owner object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.kbl.githubappcopy.model.Owner.class);
        long tableNativePtr = table.getNativePtr();
        OwnerColumnInfo columnInfo = (OwnerColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Owner.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$id();
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
        String realmGet$login = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
        }
        String realmGet$avatar_url = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$avatar_url();
        if (realmGet$avatar_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatar_urlIndex, rowIndex, realmGet$avatar_url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.avatar_urlIndex, rowIndex, false);
        }
        String realmGet$public_repos = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$public_repos();
        if (realmGet$public_repos != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.public_reposIndex, rowIndex, realmGet$public_repos, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.public_reposIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.kbl.githubappcopy.model.Owner.class);
        long tableNativePtr = table.getNativePtr();
        OwnerColumnInfo columnInfo = (OwnerColumnInfo) realm.getSchema().getColumnInfo(com.example.kbl.githubappcopy.model.Owner.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.kbl.githubappcopy.model.Owner object = null;
        while (objects.hasNext()) {
            object = (com.example.kbl.githubappcopy.model.Owner) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$id();
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
            String realmGet$login = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
            }
            String realmGet$avatar_url = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$avatar_url();
            if (realmGet$avatar_url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatar_urlIndex, rowIndex, realmGet$avatar_url, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.avatar_urlIndex, rowIndex, false);
            }
            String realmGet$public_repos = ((com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) object).realmGet$public_repos();
            if (realmGet$public_repos != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.public_reposIndex, rowIndex, realmGet$public_repos, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.public_reposIndex, rowIndex, false);
            }
        }
    }

    public static com.example.kbl.githubappcopy.model.Owner createDetachedCopy(com.example.kbl.githubappcopy.model.Owner realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.kbl.githubappcopy.model.Owner unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.kbl.githubappcopy.model.Owner();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.kbl.githubappcopy.model.Owner) cachedObject.object;
            }
            unmanagedObject = (com.example.kbl.githubappcopy.model.Owner) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface unmanagedCopy = (com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) unmanagedObject;
        com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface realmSource = (com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$login(realmSource.realmGet$login());
        unmanagedCopy.realmSet$avatar_url(realmSource.realmGet$avatar_url());
        unmanagedCopy.realmSet$public_repos(realmSource.realmGet$public_repos());

        return unmanagedObject;
    }

    static com.example.kbl.githubappcopy.model.Owner update(Realm realm, com.example.kbl.githubappcopy.model.Owner realmObject, com.example.kbl.githubappcopy.model.Owner newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface realmObjectTarget = (com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) realmObject;
        com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface realmObjectSource = (com_example_kbl_githubappcopy_model_OwnerRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$login(realmObjectSource.realmGet$login());
        realmObjectTarget.realmSet$avatar_url(realmObjectSource.realmGet$avatar_url());
        realmObjectTarget.realmSet$public_repos(realmObjectSource.realmGet$public_repos());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Owner = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{login:");
        stringBuilder.append(realmGet$login() != null ? realmGet$login() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avatar_url:");
        stringBuilder.append(realmGet$avatar_url() != null ? realmGet$avatar_url() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{public_repos:");
        stringBuilder.append(realmGet$public_repos() != null ? realmGet$public_repos() : "null");
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
        com_example_kbl_githubappcopy_model_OwnerRealmProxy aOwner = (com_example_kbl_githubappcopy_model_OwnerRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aOwner.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aOwner.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aOwner.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}

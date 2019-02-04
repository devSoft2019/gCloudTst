package com.gcloud.deviceHandler.persistence;

import com.gcloud.deviceHandler.model.Device;
import com.google.cloud.datastore.*;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component(value = "dataStoreImpl")
public class DataStoreImpl implements DataStore {

    private Datastore datastore;
    private KeyFactory keyFactory;

    public DataStoreImpl() {
        datastore = DatastoreOptions.getDefaultInstance().getService();
        keyFactory = datastore.newKeyFactory().setKind("device");
    }

    @Override
    public long saveDevice(Device device) throws SQLException {
        IncompleteKey key = keyFactory.newKey();
        FullEntity<IncompleteKey> incDeviceEntity = Entity.newBuilder(key)
                .set("idDevice", device.getIdDevice())
                .set("macAdress", device.getMacAdress())
                .set("timestamp", device.getTimestamp())
                .build();
        Entity bookEntity = datastore.add(incDeviceEntity);
        return bookEntity.getKey().getId();
    }

    @Override
    public boolean isMacAdressPresent(String macAdress) throws SQLException {
        Entity deviceEntity = datastore.get(keyFactory.newKey(macAdress)); // Load an Entity for Key(id)
        if (deviceEntity != null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Device getDevice(String macAdress) throws SQLException {
        Entity deviceEntity = datastore.get(keyFactory.newKey(macAdress));
        Device device = new Device(
                deviceEntity.getLong("idDevice"),
                deviceEntity.getString("macAdress"),
                deviceEntity.getLong("timestamp"));
        return device;
    }

    @Override
    public Device getDevice(int idDevice) throws SQLException {
        Entity deviceEntity = datastore.get(keyFactory.newKey(idDevice));
        Device device = new Device(
                deviceEntity.getLong("idDevice"),
                deviceEntity.getString("macAdress"),
                deviceEntity.getLong("timestamp"));
        return device;
    }

    @Override
    public List<Device> getAllDevices() throws SQLException {
        Query<Entity> query = Query.newEntityQueryBuilder()
                .setKind("device")
                .setLimit(10)
                .setOrderBy(StructuredQuery.OrderBy.asc("idDevice"))
                .build();

        QueryResults<Entity> resultList = datastore.run(query);
        List<Device> resultDevices = entitiesToDevices(resultList);
        return resultDevices;
    }

    public List<Device> entitiesToDevices(QueryResults<Entity> resultList) {
        List<Device> resultdevices = new ArrayList<>();
        while (resultList.hasNext()) {
            Device device = new Device(
                    resultList.next().getLong("idDevice"),
                    resultList.next().getString("macAdress"),
                    resultList.next().getLong("timestamp"));
            if(device != null){
                resultdevices.add(device);
            }
        }
        return resultdevices;
    }
}

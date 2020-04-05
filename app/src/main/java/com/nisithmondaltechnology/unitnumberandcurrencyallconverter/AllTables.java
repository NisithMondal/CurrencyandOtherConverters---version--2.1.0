package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

public class AllTables {

    private AllTables(){}

    public static final class ConvertionType{
        public static final String currency = "currency";
        public static final String angle = "angle";
        public static final String area = "area";
        public static final String length = "length";
        public static final String frequency = "frequency";
        public static final String speed = "speed";
        public static final String pressure = "pressure";
        public static final String temperature = "temperature";
        public static final String number_system = "number_system";
        public static final String time = "time";
        public static final String volume = "volume";
        public static final String weight = "weight";

    }

    public static final class ConvertHistory{
        public static final String tableName = "convert_history";
        public static final String columnId = "_id";
        public static final String columnConvertionText = "convertion_text";
        public static final String columnDate = "date";
        public static final String columnTime = "time";
        public static final String columnConvertionType = "convertion_type";//like currency,length,volume,pressure etc....
    }


}

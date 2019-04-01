package RedisInsertFailSafe;//package entPra.RedisInsertFailSafe;
//
//public void storeMsisdnInRedis() {
//    try {
//        File failedOut = new File("/Users/admin/Desktop/failed.csv");
//        ArrayList<String> msisdnList = new ArrayList<String>();
//        String msisdnCsv = "/Users/admin/Downloads/Blacklist3GPackTakers.csv";
//        CSVReader reader = new CSVReader(new FileReader(msisdnCsv));
//        String[] columns = reader.readNext();
//        while((columns = reader.readNext()) != null){
//            String fullMsisdn = Utils.get12DigitMsisdn(columns[0]);
//            msisdnList.add(fullMsisdn);
//            if(msisdnList.size() == 5000){
//                if (!failSafeRedis(redisPersistent2StringCacheService, msisdnList)) {
//                    System.err.println("failed group1");
//                    FileUtils.write(failedOut,msisdnList.toString(),true);
//                }
//            }
//        }
//        if (msisdnList.size() > 0) {
//            if (!failSafeRedis(redisPersistent2StringCacheService, msisdnList)) {
//                System.err.println("failed group1");
//                FileUtils.write(failedOut,msisdnList.toString(),true);
//            }
//        }
//        reader.close();
//    } catch (Exception e) {
//        logger.warn("Error storing msisdn " , e);
//    }
//}
//
//public static boolean failSafeRedis(RedisCacheService redisCacheService, ArrayList<String> msisdnList) {
//    int retries = 2;
//    int num = 0;
//    boolean persisted = false;
//    while (num < retries && !persisted) {
//        try {
//            num++;
//            redisCacheService.addToSet(OffersConstants.REDIS_SET_KEY_BLACKLISTED_MSISDN, msisdnList.toArray());
//            persisted = true;
//            msisdnList.clear();
//            System.out.println("Persisted in trial " + num);
//            persisted = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    if (!persisted) {
//        System.out.println("Cannot persist data in redis after 20 trials");
//    }
//    return persisted;
//}
